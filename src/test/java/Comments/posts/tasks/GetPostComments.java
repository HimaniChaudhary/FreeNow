/**
 * 
 */
package Comments.posts.tasks;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;

import Comments.posts.PostsTaskManager;
import pojos.comments.CommentsData;
import utils.RequestBuilder;

public class GetPostComments {

	PostsTaskManager manager = null;

	public GetPostComments(PostsTaskManager manager) {
		this.manager = manager;
		RequestBuilder requestBuilder = new RequestBuilder();
		requestBuilder.setEndPoint("https://jsonplaceholder.typicode.com/comments");
		Response repsonse = requestBuilder.executeGet();
		Gson gson = new Gson();
		CommentsData[] commentsArray = gson.fromJson(repsonse.asString(), CommentsData[].class);
		manager.setCommentsArray(commentsArray);
	}

}
