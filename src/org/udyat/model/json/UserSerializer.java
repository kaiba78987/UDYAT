/**
 * 
 */
package org.udyat.model.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.udyat.model.Project;
import org.udyat.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/** This class provides a simple way to serialize User objects into JSON objects. It doesn't serialize the password.
 * @author Estrada Martínez, F.J.
 *
 */
public class UserSerializer implements JsonSerializer<User> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(User user, Type type,
					JsonSerializationContext context) {
		Gson gson = new Gson ();
		JsonObject jsonUser = new JsonObject ();
		
			//Serialize basic data.
			jsonUser.addProperty("username", user.getName());
		jsonUser.addProperty("email", user.getEmail());
		
		// Serialize dates.
		String registerDate = gson.toJson(user.getRegistered());
				String lastEntrance = gson.toJson(user.getLastEntrance());
		jsonUser.addProperty("registered",  registerDate);
		jsonUser.addProperty("lastEntrance",  lastEntrance);;
		
		/* Serialize collections.
		We use clone methods because changes may affect the entity.*/
		List<Project> participated=new ArrayList<Project> (user.getParticipatedProjects());
		List<Project> contributed=new ArrayList<Project>(user.getContributedProjects());
		List<Project> managed=new ArrayList<Project>(user.getManagedProjects());
		List<Project> own=new ArrayList<Project>(user.getOwnProjects());
		/*Collections.copy(participated, user.getParticipatedProjects());
		Collections.copy(contributed, user.getContributedProjects());
		Collections.copy(managed, user.getManagedProjects());
		Collections.copy(own, user.getOwnProjects());*/
		// Remove duplicates.x
		managed.removeAll(own);
		contributed.removeAll(managed);
		participated.removeAll(contributed);
		// Serialize and add to a general list.
		JsonArray projects = new JsonArray();
		projects.addAll(serializeProjects(own, "owner"));
		projects.addAll(serializeProjects(managed, "administrator"));
		projects.addAll(serializeProjects(contributed, "contributor"));
		projects.addAll(serializeProjects(participated, "participant"));
		jsonUser.add("projects",  projects);
		
		return jsonUser;
	}

	/**
	 * This method serializes a collection of projects and adds the type to each object.
	 * @param projects The collection of projects.
	 * @param participationType The user participation type.
	 * @return A json array.
	 */
	protected JsonArray serializeProjects (List<Project> projects, String participationType) {
		// Customize the serializtion procedure.
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Project.class,  new ProjectIDSerializer());
		Gson gson = builder.create();
		
		JsonArray array = new JsonArray();
		for (Project p: projects) {
			JsonElement projectJson = gson.toJsonTree(p);
			projectJson.getAsJsonObject().addProperty("participation", participationType);
			array.add(projectJson);
		}
		return array;
	}
	
}
