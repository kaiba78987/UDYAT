/**
 * 
 */
package org.udyat.model.json;

import java.lang.reflect.Type;

import org.udyat.model.Model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/** This class serializes a Model object into a JSON object. It only serializes the owner project ID and model name.
 * @author Estrada Martínez, F.J.
 *
 */
public class ModelIDSerializer implements JsonSerializer<Model> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(Model model, Type type,
			JsonSerializationContext context) {
		JsonObject jsonModel = new JsonObject();
		jsonModel.addProperty("projectID",  model.getId());
		jsonModel.addProperty("title",  model.getTitle());
		return jsonModel;
	}

}
