/**
 * 
 */
package Comments.posts;

import pojos.comments.CommentsData;
import pojos.posts.PostsData;
import pojos.user.UserData;

public class PostsTaskManager {

	private UserData[] userArray;
	private PostsData[] postArray;
	private CommentsData[] commentsArray;

	public UserData[] getUserArray() {
		return userArray;
	}

	public void setUserArray(UserData[] userArray) {
		this.userArray = userArray;
	}

	public PostsData[] getPostArray() {
		return postArray;
	}

	public void setPostArray(PostsData[] postArray) {
		this.postArray = postArray;
	}

	public CommentsData[] getCommentsArray() {
		return commentsArray;
	}

	public void setCommentsArray(CommentsData[] commentsArray) {
		this.commentsArray = commentsArray;
	}

}
