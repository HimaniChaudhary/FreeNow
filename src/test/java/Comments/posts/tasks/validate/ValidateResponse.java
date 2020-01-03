package Comments.posts.tasks.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.testng.asserts.SoftAssert;

import Comments.posts.PostsTaskManager;
import pojos.comments.CommentsData;
import pojos.posts.PostsData;
import pojos.user.UserData;

public class ValidateResponse {

	private UserData[] userArray;
	private PostsData[] postArray;
	private CommentsData[] commentsArray;
	SoftAssert softAssert;

	public ValidateResponse(PostsTaskManager manager) {
		this.userArray = manager.getUserArray();
		this.postArray = manager.getPostArray();
		this.commentsArray = manager.getCommentsArray();
	}
	
	/*
	 * method to validate whether the comment has valid email or not
	 */
	public void printAllTheCommentsOfaGivenUser(String userName, SoftAssert softAssert) {
		this.softAssert = softAssert;
		Integer userId = getUserIdOfaGivenUser(userName);
		if(null != userId) {
		List<CommentsData> comments = getAllTheCommentsOfaGivenUser(userId);
		System.out.println("total comments of this user are -->"+ comments.size());
		if(!comments.isEmpty()){
			for(CommentsData comment:comments) {
				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
						"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		 
				Pattern pat = Pattern.compile(emailRegex);
		
				if(pat.matcher(comment.getEmail()).matches()) {
				}
				else {
				 softAssert.assertFalse(true,"Email is incorrect --> " + comment.getEmail()+"For this Comment Id --> " + comment.getId() );
				}
			}
	} else {
		softAssert.assertFalse(true,"This user doesn't have any comments on it's posts");
	}} else {
		softAssert.assertFalse(true,"This user doesn't exist");
	}
		}

	/*
	 * method to fetch all the comments of given user*
	 */
	private List<CommentsData> getAllTheCommentsOfaGivenUser(Integer userId) {
		List<CommentsData> comments = new ArrayList<CommentsData>();
			List<PostsData> posts = getPostForTheGivenUserId(userId);
			if (!posts.isEmpty()) {
				comments = getCommentsForGivenPosts(posts);
			} else {
				softAssert.assertFalse(true,"This User doesn't have any post");
			}
		return comments;
	}

	/*
	 * method to return userId of given user*
	 */
	private Integer getUserIdOfaGivenUser(String UserName) {
		for (UserData user : userArray) {
			if (user.getUsername().equalsIgnoreCase(UserName)) {
				return user.getId();
			}
		}
		return null;
	}

	/*
	 * method to traverse all the posts for given user
	 */
	private List<PostsData> getPostForTheGivenUserId(Integer userId) {
		List<PostsData> postsForGivenUser = new ArrayList<PostsData>();
		for (PostsData post : postArray) {
			if (post.getUserId()==userId) {
				postsForGivenUser.add(post);
			}
		}
		return postsForGivenUser;
	}

	/*
	 * method to traverse through the comments of posts
	 */
	private List<CommentsData> getCommentsForGivenPosts(List<PostsData> posts) {
		List<CommentsData> commentsForGivenPosts = new ArrayList<CommentsData>();
		for (PostsData post : posts) {
			for (CommentsData comment : commentsArray) {
				if (comment.getPostId()==post.getId()) {
					commentsForGivenPosts.add(comment);
				}
			}
		}
		return commentsForGivenPosts;
	}
	
}
