package in.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.user.entity.User;
import in.user.repository.userRepository;

@RestController
public class userController {
    @Autowired
	private userRepository userRepo;
    
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<>(userRepo.save(user),HttpStatus.CREATED);
    		
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUser(){
    	return new ResponseEntity<>(userRepo.findAll(),HttpStatus.OK);
    }
    
    @GetMapping("/getUser/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id){
    	Optional <User> user=userRepo.findById(id);
    	return new ResponseEntity<>(user,HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User userDetails){
		Optional<User> user=userRepo.findById(id);
		if(user.isPresent()) {
			User updatedUser=user.get();
			updatedUser.setUserName(userDetails.getUserName());
			updatedUser.setPassword(userDetails.getPassword());
			updatedUser.setEmail(userDetails.getEmail());
			updatedUser.setRoles(userDetails.getRoles());
			return new  ResponseEntity<>(userRepo.save(updatedUser),HttpStatus.OK);
		}
		else {
            return ResponseEntity.notFound().build();
        }
    	
    }
    
    
    
}
