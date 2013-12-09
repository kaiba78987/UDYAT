/**
 * 
 */
package org.udyat.model.json;

import java.lang.reflect.Type;

import org.udyat.model.User;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/** This class serializes a User object into a JSON object. It only serializes the username.
 * @author Estrada Martínez, F.J.
 *
 */
public class UserIDSerializer implements JsonSerializer<User> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(User user, Type type,
			JsonSerializationContext context) {
		JsonObject jsonUser = new JsonObject();
		jsonUser.addProperty("username", user.getName());
		return jsonUser;
	}

}
