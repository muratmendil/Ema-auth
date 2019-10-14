package com.formation.api;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exeption.ErrorExeption;
import com.formation.model.User;
import com.formation.service.UserService;

@RestController
@RequestMapping("/auth")
@EnableEurekaClient
public class UserApi {
	
	@Autowired UserService userService;
	
	@PostMapping("/login")
	 public ResponseEntity<User> loginUser(@Valid @RequestBody User user){
		try {
			User logUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
			return ResponseEntity.ok(logUser);
		} catch (ErrorExeption e) {
			return ResponseEntity.ok(new User());
		} 
	 }
	
	@PostMapping("/signUp")
	 public ResponseEntity<User> signUpUser(@Valid @RequestBody User user){
		User existUser;
		try {
			existUser = userService.findByEmail(user.getEmail());
			if(existUser.getEmail() != null) {
				System.out.println("user exist");
				return ResponseEntity.ok(new User());
			} else {
				try {
					System.out.println("user dont exist");
					User newUser = userService.createUser(user);
					return ResponseEntity.ok(newUser);
				} catch (ErrorExeption e) {
					return ResponseEntity.ok(new User());
				} 
			}

		} catch (ErrorExeption e1) {
			return ResponseEntity.ok(new User());
		} 
	 }
	
	@PostMapping("/test")
	 public ResponseEntity<User> test(@Valid @RequestBody User user){		
		try {
			System.out.println("user dont exist");
			User newUser = userService.createUser(user);
			return ResponseEntity.ok(newUser);
		} catch (ErrorExeption e) {
			return ResponseEntity.ok(new User());
		} 
	 }
	
	@GetMapping("test2")
	public User getTest2() {
		try {
			User logUser = userService.findByEmailAndPassword("dadie.emilin", "toto");
			return logUser;
		} catch (ErrorExeption e) {
			return new User();
		} 	
	}
	
	 @GetMapping("{id}")
	 public User findById (@PathVariable(value = "id") int id){
		
		 User user = new User();
			try {
				user = userService.findById(id);
				return user;
			} catch (ErrorExeption e) {
				return user;
			}
	 }

}
