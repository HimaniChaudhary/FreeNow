# REST Assured Automation

## Folder structure
src folder contains three different folders
1. java
	1.1 Comments
	1.1.1 posts
		a) cases folder that contains Test_IT.java class which is used to run the test cases through TestNG.
			- This class calls ValidateResponse.java for test assertions.
		b) tasks folder that contains 
			i. GetUsers.java class has method to get users
			ii. GetUserPosts.java class has method to get users' posts
			iii. GetPostComments.java class has method to get posts' comments
			iv. validate folder contains ValidateResponse.java which is used to validate the response of APIs
				- This class validates the response for valid, invalid user.
				- This class validate the response for posts exist or not.
				- validates the response for comments exist or not.
				- uses softAssertions for validation.
		c) PostsTaskManager.java class which is used to get and set the the data of the APIs
2. pojos
	2.1 comments contains CommentsData.java class which is used to map keys of Comments API response JSON
	2.2 posts contains PostsData.java class which is used to map keys of Posts API response JSON
	2.3 user contains following classes
		2.3.1 Address.java class which is used to map nested keys of Address Key in Users API response JSON
		2.3.2 Company.java class which is used to map nested keys of Company Key in Users API response JSON
		2.3.3 Geo.java class which is used to map nested keys of Geo Key in Users API response JSON
		2.3.4 UserData.java class which is used to map keys of Users API response JSON
3. utils folder contains RequestBuilder.java class which is used to build all the calls (GET, POST, PUT and DELETE) of REST Assured



## Pre-requisite
1. Java 1.8. or above
2. Maven version 3.0 or above
3. TestNG 6.14.3 or above

		
## Reporting
1. Reports are getting generated using TestNG as well JUnit.
2. Old reports are getting stored in another folder


## Git Repository for the source.
https://github.com/HimaniChaudhary/FreeNow.git

