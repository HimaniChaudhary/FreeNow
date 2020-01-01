/**
 * 
 */
package Comments.posts.tasks;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import Comments.posts.PostsTaskManager;
import pojos.posts.PostsData;
import utils.RequestBuilder;

public class GetUserPosts {

	PostsTaskManager manager = null;

	public GetUserPosts(PostsTaskManager manager) {
		this.manager = manager;
		RequestBuilder requestBuilder = new RequestBuilder();
		requestBuilder.setEndPoint("https://jsonplaceholder.typicode.com/posts");
		Response repsonse = requestBuilder.executeGet();
		Gson gson = new Gson();
		PostsData[] postArray = gson.fromJson(repsonse.asString(), PostsData[].class);
		manager.setPostArray(postArray);
	}

}
