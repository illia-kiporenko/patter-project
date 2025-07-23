package me.kiporenko.system.service;

import me.kiporenko.system.model.Blog;

import java.util.List;

public interface BlogService {

	List<Blog> getBlogs();

	Blog getBlogById(Long id);

	Blog createBlog(Blog blog);

	void deleteBlog(Long id);

	Blog updateBlog(Blog blog, long id);

}
