package me.kiporenko.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.kiporenko.system.repository.BlogRepository;
import me.kiporenko.system.service.BlogService;
import me.kiporenko.system.exception.EntityNotFoundException;
import me.kiporenko.system.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> getBlogs() {
        log.info("Get all blogs");
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(Long id) {
	    log.info("Get blog by id: {}", id);
        return blogRepository.getBlogById(id);
    }

    @Override
    public Blog createBlog(Blog blog) {
        log.info("Creating blog {}", blog);
        blogRepository.save(blog);
        return blog;
    }

    @Override
    public void deleteBlog(Long id) {
        log.info("Deleting blog {}", id);
        blogRepository.deleteBlogById(id);
    }

    @Override
    public Blog updateBlog(Blog blog, long id) {
        log.info("Update blog with id {}", id);
        Blog blogToUpdate = blogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Blog", id));

        if(blog.getTitle() != null){
            blogToUpdate.setTitle(blog.getTitle());
        }

        blogRepository.save(blogToUpdate);

        return blogToUpdate;
    }
}
