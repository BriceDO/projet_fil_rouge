package controllers;

import java.util.List;

import model.User;
import services.UserService;

public class UserController {
	
			public void signUp(User user) {
				// TODO if(req.body != null {
			}
				.
				User userModel = new User(1,"toto","titi","a@test.fr","PASSWORD") ;  
				UserService userService =  new UserService() ; 
				userService.createUSer(userModel);
			}
	
	
			public User getUser() {
				
				return null ; 
			}
			
			public List<User> getUsers() {
				return null ;			
						}

}
