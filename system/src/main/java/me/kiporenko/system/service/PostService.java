package me.kiporenko.system.service;

import me.kiporenko.system.model.Post;

import java.util.List;

public interface PostService {

	List<Post> getPosts(Long blogId);

	Post getPostById(Long id);

	void createPost(Post post);

	void deletePost(Long postId);

	void updatePost(Post post, Long id);
}
