package me.kiporenko.system.repository;

import me.kiporenko.system.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findAllByBlogId(Long blogId);

	void deletePostById(Long postId);
}
