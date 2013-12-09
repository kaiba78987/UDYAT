package org.udyat.model.json;

import org.udyat.model.BCryptUserFactory;
import org.udyat.model.Project;
import org.udyat.model.SafeProjectFactory;
import org.udyat.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PruebaSerializer {

	public static void main(String[] args) {
		User user1 = new BCryptUserFactory().createUser("Pablo", "patata", "pablo@gmail.com");
		User user2 = new BCryptUserFactory().createUser("David", "potorro", "david@gmail.com");
		Project project1 = new SafeProjectFactory().createProject("Proyecto hombres G", user1);
		project1.setId((long)2);;
		Project project2 = new SafeProjectFactory().createProject("Proyecto Manhattan", user2);
		project2.setId((long)3);
		// UserHandler handler = UserHandler.createHandler(UserRole.CONTRIBUTOR);
		
		try {
		//handler.setRole(user1, project2);
			user1.getContributedProjects().add(project2);
		
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(User.class,  new UserSerializer());
		Gson gson = builder.create();
		
		System.out.println(gson.toJson(user1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
