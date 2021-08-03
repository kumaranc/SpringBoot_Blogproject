package com.blogproject.blogs;

import java.util.Optional;
import java.util.function.Function;

import com.blogproject.users.User;
import com.blogproject.users.UserService;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

	private BlogRepository blogRepository;
	private UserService userService;

	@Autowired
	public void setBlogRepository(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Blog createBlog(BlogDTO blogDTO) {
		Blog blog = blogRepository.save(blogDataMaping.apply(blogDTO));
		return blog;
	}
	
	public Blog getBlog(int blogid) {
		Optional<Blog> optBlog = blogRepository.findById(blogid);
		Blog blog = optBlog.get();
//		Blog blog = blogRepository.getById(blogid);
		return blog;
	}
	
	Function<BlogDTO, Blog> blogDataMaping = (blogDTO) -> {
		Blog blog = new Blog();
		blog.setId(blogDTO.getId());
		blog.setBlogname(blogDTO.getBlogname());
		blog.setQuestion(blogDTO.getQuestion());
		blog.setComments(blogDTO.getComments());
		User user = userService.getUserWithID(blogDTO.getUserid());
		blog.setUser(user);
		return blog;
	};
}
