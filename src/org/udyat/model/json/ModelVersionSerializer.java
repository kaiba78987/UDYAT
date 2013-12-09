/**
 * 
 */
package org.udyat.model.json;

import java.lang.reflect.Type;

import org.udyat.model.ModelVersion;
import org.udyat.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/** This class serializes ModelVersion objects into JSON objects, excluding the XMI datas.
 * @author Estrada Martínez, F.J.
 *
 */
public class ModelVersionSerializer implements JsonSerializer<ModelVersion> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(ModelVersion version, Type type,
			JsonSerializationContext context) {
		//  Prepair serialization.
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(User.class,  new UserIDSerializer());
		Gson gson = builder.create();
		
		// Serialize basic datas.
		JsonObject jsonVersion = new JsonObject ();
		jsonVersion.addProperty("date",  gson.toJson(version.getId().getVersion()));;
		jsonVersion.add("modifier", gson.toJsonTree(version.getModifier()));
		jsonVersion.addProperty("conflictive",  gson.toJson(version.getConflictive()));;
		
		return jsonVersion;
	}

}
