package me.kiporenko.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.kiporenko.system.repository.PostRepository;
import me.kiporenko.system.service.PostService;
import me.kiporenko.system.exception.EntityNotFoundException;
import me.kiporenko.system.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	@Autowired
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<Post> getPosts(Long blogId) {
		log.info("Get posts by blog Id: {}", blogId);
		return postRepository.findAllByBlogId(blogId);
	}

	@Override
	public Post getPostById(Long id) {
		log.info("Get post by id: {}", id);
		return postRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Post ", id)
		);
	}

	@Override
	public void createPost(Post post) {
		log.info("Creating post: {}", post);
		postRepository.save(post);
	}

	@Override
	public void deletePost(Long postId) {
		postRepository.deletePostById(postId);
	}

	@Override
	public void updatePost(Post post, Long id) {
		log.info("Update customer with id {}", id);
		Post postToUpdate = postRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Post", id));

		if(post.getTitle() != null) {
			postToUpdate.setTitle(post.getTitle());
		}
		if(post.getPlot() != null) {
			postToUpdate.setPlot(post.getPlot());
		}
		if(post.getLikesNumber()!=null){
			postToUpdate.setLikesNumber(post.getLikesNumber());
		}
		if(post.getDislikesNumber()!=null){
			postToUpdate.setDislikesNumber(post.getDislikesNumber());
		}

		postRepository.save(postToUpdate);
	}
}
