package dev.joaonovais.blog.repositories;

import dev.joaonovais.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
