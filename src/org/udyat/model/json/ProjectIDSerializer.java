/**
 * 
 */
package org.udyat.model.json;

import java.lang.reflect.Type;

import org.udyat.model.Project;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/** This class provides a simple way to serialize Project objects into JSON objects. It only serialize project ID, name and creation date.
 * @author Estrada Martínez, F.J.
 *
 */
public class ProjectIDSerializer implements JsonSerializer<Project> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(Project project, Type type,
			JsonSerializationContext context) {
		Gson gson = new Gson ();
		JsonObject jsonProject = new JsonObject ();
		
		// serialize datas.
		jsonProject.addProperty("id", project.getId().toString());
		jsonProject.addProperty("name", project.getTitle());
		jsonProject.addProperty("creation", gson.toJson(project.getCreated()));
		
		return jsonProject;
	}

}
