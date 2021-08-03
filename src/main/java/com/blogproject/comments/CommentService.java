package com.blogproject.comments;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogproject.blogs.Blog;
import com.blogproject.blogs.BlogService;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	BlogService blogService;
	
	public Comment createComment(CommentDTO commentDTO, int blogid) {
		Blog blog = blogService.getBlog(blogid);
		commentDTO.setBlog(blog);
		Comment comment = commentRepository.save(commentDataMapping.apply(commentDTO));
		return comment;
	}
	
	public List<Comment> getCommentByBlogId(String blogid) {
		List<Comment> comments = commentRepository.findAll();
		return comments;
	}

	Function<CommentDTO, Comment> commentDataMapping = (commentDTO) -> {
		Comment comment = new Comment();
		comment.setData(commentDTO.getData());
		comment.setParentcomment(commentDTO.getParentcomment());
		return comment;
	};
}
