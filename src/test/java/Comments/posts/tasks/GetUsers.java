/**
 * 
 */
package Comments.posts.tasks;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;


import Comments.posts.PostsTaskManager;
import pojos.user.UserData;
import utils.RequestBuilder;

public class GetUsers {

	PostsTaskManager manager = null;

	public GetUsers(PostsTaskManager manager) {
		this.manager = manager;
		RequestBuilder requestBuilder = new RequestBuilder();
		requestBuilder.setEndPoint("https://jsonplaceholder.typicode.com/users");
		Response repsonse = requestBuilder.executeGet();
		Gson gson = new Gson();
		UserData[] userArray = gson.fromJson(repsonse.asString(), UserData[].class);
		manager.setUserArray(userArray);
	}

}
