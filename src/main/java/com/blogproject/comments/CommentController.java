package com.blogproject.comments;

import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.MediaTray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createComment(@RequestBody CommentDTO commentDTO) {
		Comment comment = commentService.createComment(commentDTO, 1);
		return ResponseEntity.ok(comment);
	}
	
	@GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void getCommentList(@PathVariable String id) {
		 List<Comment> comments = commentService.getCommentByBlogId(id); 
		 comments.forEach(comment -> System.out.println(comment));
	}
}
