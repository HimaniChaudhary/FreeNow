/**
 * 
 */
package Comments.posts.cases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Comments.posts.PostsTaskManager;
import Comments.posts.tasks.GetPostComments;
import Comments.posts.tasks.GetUserPosts;
import Comments.posts.tasks.GetUsers;
import Comments.posts.tasks.validate.ValidateResponse;

public class Test_IT {
	PostsTaskManager manager = new PostsTaskManager();
	ValidateResponse validateResponse;

	@BeforeClass
	void excecuteRequest() {
		try {
			new GetUsers(manager);
			new GetUserPosts(manager);
			new GetPostComments(manager);
			validateResponse = new ValidateResponse(manager);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		validateResponse.printAllTheCommentsOfaGivenUser("Samantha");
	}

}
