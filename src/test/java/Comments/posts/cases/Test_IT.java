/**
 * 
 */
package Comments.posts.cases;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import Comments.posts.PostsTaskManager;
import Comments.posts.tasks.*;
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
		SoftAssert softAssert = new SoftAssert();
		validateResponse.printAllTheCommentsOfaGivenUser("Samantha", softAssert);
		softAssert.assertAll();
	}
	
	@Test
	public void testOne() {
		SoftAssert softAssert = new SoftAssert();
		validateResponse.printAllTheCommentsOfaGivenUser("ABC", softAssert);
		softAssert.assertAll();
	}

}
