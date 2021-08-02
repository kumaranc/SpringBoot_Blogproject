package com.blogproject.blogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogproject.comments.Comment;

@RestController
@RequestMapping(path = "/api/v1/blog")
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@GetMapping(path = "/get/{id}")
	public ResponseEntity<Object> getBlog(@PathVariable int id) {
		Blog blog= blogService.getBlog(id);
		System.out.println(blog);
		return ResponseEntity.ok(blog);
	}
	
	@PostMapping(path="/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveBlog(@RequestBody BlogDTO blogDTO) {
		Blog blog = blogService.createBlog(blogDTO);
		return ResponseEntity.ok(blog);
	}
}
