package com.example.TestCRUD.service;

import com.example.TestCRUD.model.Post;
import com.example.TestCRUD.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setAuthorId(postDetails.getAuthorId());
        post.setPostType(postDetails.getPostType());
        post.setDate(postDetails.getDate());
        post.setDepartureLocation(postDetails.getDepartureLocation());
        post.setDestinationLocation(postDetails.getDestinationLocation());
        post.setTravelDescription(postDetails.getTravelDescription());
        post.setDriverRequirements(postDetails.getDriverRequirements());
        post.setCurrentPassengers(postDetails.getCurrentPassengers());
        post.setMaxPassengers(postDetails.getMaxPassengers());
        post.setVehicleInfo(postDetails.getVehicleInfo());

        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
