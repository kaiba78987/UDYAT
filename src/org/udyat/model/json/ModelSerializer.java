/**
 * 
 */
package org.udyat.model.json;

import java.lang.reflect.Type;

import org.udyat.model.Model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/** This class serializes Model objects into JSON objects.
 * @author Estrada Martínez, F.J.
 *
 */
public class ModelSerializer implements JsonSerializer<Model> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(Model model, Type type,
			JsonSerializationContext context) {
		Gson gson = new Gson ();
		JsonObject jsonModel = new JsonObject();
		
		jsonModel.addProperty("projectID",  model.getOwner().getId());
		jsonModel.addProperty("id",  model.getId());;
		jsonModel.addProperty("title",  model.getTitle());
		jsonModel.addProperty("created", gson.toJson(model.getCreated()));
		
		return jsonModel;
	}

}
