package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Exceptions.BlogPostNotFound;
import com.Elliott.Engineering.Website.Models.BlogPost;
import com.Elliott.Engineering.Website.Repositories.BlogPostRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogPostService {


    private BlogPostRepository blogPostRepository;


    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    //save item
    //get by id

    public BlogPost saveBlogPost(BlogPost blogPost){
        blogPost.setDate(new Date());
        return blogPostRepository.save(blogPost);
    }

    public BlogPost getById(Long id) throws BlogPostNotFound {
       BlogPost post = blogPostRepository.getBlogPostById(id).orElseThrow(()->new BlogPostNotFound("Blog post not found"));
       return post;
    }

    public List<BlogPost> getAllBlogPosts() throws BlogPostNotFound {
        List<BlogPost> blogPosts = blogPostRepository.getAllBlogPost().orElseThrow(
                ()->new BlogPostNotFound("No blog posts found")
        );
        return blogPosts;
    }
}
