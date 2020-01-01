package Comments.posts.tasks.validate;

import java.util.ArrayList;
import java.util.List;

import Comments.posts.PostsTaskManager;
import pojos.comments.CommentsData;
import pojos.posts.PostsData;
import pojos.user.UserData;

public class ValidateResponse {

	private UserData[] userArray;
	private PostsData[] postArray;
	private CommentsData[] commentsArray;

	public ValidateResponse(PostsTaskManager manager) {
		this.userArray = manager.getUserArray();
		this.postArray = manager.getPostArray();
		this.commentsArray = manager.getCommentsArray();
	}

	public void printAllTheCommentsOfaGivenUser(String userName) {
		List<CommentsData> comments = getAllTheCommentsOfaGivenUser(userName);
		if(!comments.isEmpty()){
			for(CommentsData comment:comments) {
				System.out
				.println("CommentId is --> " + comment.getId() + " and the Email in this comment is --> " + comment.getEmail());
				//Write code to validate Email.
				// validateEmail(comments){}
			}
	} else {
		System.out.println("This user doesn't have any comments on it's posts");
	}

	}

	private List<CommentsData> getAllTheCommentsOfaGivenUser(String userName) {
		List<CommentsData> comments = new ArrayList<CommentsData>();
		Integer userId = getUserIdOfaGivenUser(userName);
		if (null != userId) {
			List<PostsData> posts = getPostForTheGivenUserId(userId);
			if (!posts.isEmpty()) {
				comments = getCommnetsForGivenPosts(posts);
			} else {
				System.out.println("This User doesn't have any post");
			}
		} else {
			System.out.println("User Id for this User Does not exist");
		}

		return comments;
	}

	private Integer getUserIdOfaGivenUser(String UserName) {
		for (UserData user : userArray) {
			if (user.getUsername().equalsIgnoreCase(UserName)) {
				return user.getId();
			}
		}
		return null;
	}

	private List<PostsData> getPostForTheGivenUserId(Integer userId) {
		List<PostsData> postsForGivenUser = new ArrayList<PostsData>();
		for (PostsData post : postArray) {
			if (post.getUserId()==userId) {
				postsForGivenUser.add(post);
			}
		}
		return postsForGivenUser;
	}

	private List<CommentsData> getCommnetsForGivenPosts(List<PostsData> posts) {
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
