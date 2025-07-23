package me.kiporenko.system.controller;

import me.kiporenko.system.service.impl.BlogServiceImpl;
import me.kiporenko.system.service.impl.PostServiceImpl;
import me.kiporenko.system.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/blog")
public class BlogController {

    private final BlogServiceImpl blogService;

    private final PostServiceImpl postService;

    @Autowired
    public BlogController(BlogServiceImpl blogService, PostServiceImpl postService) {
        this.blogService = blogService;
        this.postService = postService;
    }

    @GetMapping
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping
    public Blog addBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @PatchMapping("/{id}")
    public Blog updateBlog(@RequestBody Blog blog, @PathVariable Long id) {
        return blogService.updateBlog(blog, id);
    }

    @DeleteMapping
    public void deleteBlog(@RequestParam Long id) {
        blogService.deleteBlog(id);
    }
}
