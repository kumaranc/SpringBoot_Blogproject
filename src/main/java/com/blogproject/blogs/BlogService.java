package com.blogproject.blogs;

import java.util.Optional;
import java.util.function.Function;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

	@Autowired
	BlogRepository blogRepository;
	
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
		blog.setDate(blogDTO.getDate());
		blog.setComments(blogDTO.getComments());
		return blog;
	};
}
