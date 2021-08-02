package com.blogproject.users;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogproject.advisor.CustomException;
import com.blogproject.advisor.ExceptionResponse;

@RestController
@RequestMapping(path="/api/v1/user")
public class UserController {

    @Autowired
    public UserService userService;
    
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
//        try {
        	User user = userService.createUser(userDTO);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
//        } catch(CustomException ex) {
//        	ExceptionResponse respose =new ExceptionResponse(ex.getErrorCode(), ex.getErrorMessage(), ex.getDate());
//        	return new ResponseEntity<ExceptionResponse>(respose, HttpStatus.BAD_REQUEST);
//        } catch (Exception ex) {
//        	ExceptionResponse respose =new ExceptionResponse("604", "Something went wrong in controller "+ ex.getMessage(), new Date()+"");
//        	return new ResponseEntity<ExceptionResponse>(respose, HttpStatus.BAD_REQUEST);
//		}
    	
    }
}
