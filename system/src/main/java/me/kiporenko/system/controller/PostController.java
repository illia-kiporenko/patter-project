package me.kiporenko.system.controller;

import me.kiporenko.system.service.PostService;
import me.kiporenko.system.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/post")
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping
	public List<Post> getAllPostsByBlogId(@RequestParam Long blogId) {
		return postService.getPosts(blogId);
	}

	@GetMapping("/{postId}")
	public Post getPostById(@PathVariable Long postId) {
		return postService.getPostById(postId);
	}

	@PostMapping
	public Post addPost(@RequestBody Post post) {
		postService.createPost(post);
		return postService.getPostById(post.getId());
	}

	@PatchMapping("/{postId}")
	public Post updatePost(@RequestBody Post post, @PathVariable Long postId) {
		postService.updatePost(post, postId);
		return postService.getPostById(postId);
	}

	@DeleteMapping("/{postId}")
	public void deletePostById(@PathVariable Long postId) {
		postService.deletePost(postId);
	}


}
