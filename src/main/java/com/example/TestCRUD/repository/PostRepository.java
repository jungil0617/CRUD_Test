package com.example.TestCRUD.repository;

import com.example.TestCRUD.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
