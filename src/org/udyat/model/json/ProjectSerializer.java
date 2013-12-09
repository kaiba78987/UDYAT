/**
 * 
 */
package org.udyat.model.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.udyat.model.Model;
import org.udyat.model.Project;
import org.udyat.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/** This class serializers a Project object into a JSON object. It serializes all fields, grouping participants into an array.
 * @author Estrada Martínez, F.J.
 *
 */
public class ProjectSerializer implements JsonSerializer<Project> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(Project project, Type type,
			JsonSerializationContext context) {
		// Prepairing parsers.
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(User.class,  new UserIDSerializer());
		Gson gson = builder.create();
		JsonObject jsonProject = new JsonObject();
		
		// Serialize basic datas.
		jsonProject.addProperty("id",  project.getId().toString());
		jsonProject.addProperty("name", project.getTitle());
		jsonProject.addProperty("created", gson.toJson(project.getCreated()));
		jsonProject.addProperty("publicAccess",  project.getPublicAccess().toString());
		
		// Complex fields.
		jsonProject.add("creator", gson.toJsonTree(project.getCreator()));
		
		/* To serialize participants.
		 * Copy user collections to prevent problems with entitiess serialization.*/
		List<User> participants = new ArrayList<User>(project.getParticipants());
				List<User> contributors = new ArrayList<User>(project.getContributors());
				List<User> administrators = new ArrayList<User>(project.getAdministrators());
				// remove duplicates.
				administrators.remove(project.getCreator());
				contributors.removeAll(administrators);
				participants.removeAll(contributors);
				//Serialize collections.
		JsonArray array = new JsonArray();
		array.addAll(serializeUsers(administrators, "administrator"));;
		array.addAll(serializeUsers(contributors, "contributor"));;
		array.add(serializeUsers(participants, "participants"));;
		jsonProject.add("participants", array);
		
		// Serialize models ids.
		JsonArray models = serializeModels(project.getModels());
		jsonProject.add("models",  models);
		
		return jsonProject;
	}

	private JsonArray serializeUsers (List<User> users, String type) {
		// Prepairing parsers.
				GsonBuilder builder = new GsonBuilder();
				builder.registerTypeAdapter(User.class,  new UserIDSerializer());
				Gson gson = builder.create();
				
				// Serializes the collection.
				JsonArray array = new JsonArray();
				for (User u: users) {
					JsonElement jsonUser = gson.toJsonTree(u);
					jsonUser.getAsJsonObject().addProperty("role",  type);
					array.add(jsonUser);
				}
				return array;
	}
	
	private JsonArray serializeModels (List<Model> models) {
		// Prepairing parsers.
				GsonBuilder builder = new GsonBuilder();
				builder.registerTypeAdapter(Model.class,  new ModelIDSerializer());
				Gson gson = builder.create();
				
				// Serializes the collection.
				JsonArray array = new JsonArray();
				for (Model m: models) {
					JsonElement jsonModel = gson.toJsonTree(m);
					array.add(jsonModel);
				}
				return array;
	}
	
}
