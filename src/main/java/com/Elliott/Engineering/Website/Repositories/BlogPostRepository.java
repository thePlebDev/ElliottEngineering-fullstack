package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {



    @Query(value = "SELECT * FROM blog_post WHERE id = ?1",nativeQuery = true)
    Optional<BlogPost> getBlogPostById(Long id);

    @Query(value="SELECT * FROM blog_post WHERE title = ?1",nativeQuery = true)
    Optional<BlogPost> getByTitle(String title);

    @Query(value = "SELECT * FROM blog_post ORDER BY date ASC",nativeQuery = true)
    Optional<List<BlogPost>> getByDateLatest();

    @Query(value = "SELECT * FROM blog_post ORDER BY date DESC",nativeQuery = true)
    Optional<List<BlogPost>> getByDateOldest();

    @Query(value = "SELECT * FROM blog_post",nativeQuery = true)
    Optional<List<BlogPost>> getAllBlogPost();



}
