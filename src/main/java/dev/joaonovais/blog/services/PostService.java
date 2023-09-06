package dev.joaonovais.blog.services;

import dev.joaonovais.blog.dtos.PostDTO;
import dev.joaonovais.blog.entities.Post;
import dev.joaonovais.blog.exceptions.EntityNotFoundException;
import dev.joaonovais.blog.repositories.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post findPostById(Long id){
        return postRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Post not found with ID " + id));
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post editPost(Long id, Post newPost) {
        Post post = findPostById(id);
        Instant instant = post.getDate();
        BeanUtils.copyProperties(newPost, post);
        post.setId(id);
        post.setDate(instant);
        return postRepository.save(post);
    }

}
