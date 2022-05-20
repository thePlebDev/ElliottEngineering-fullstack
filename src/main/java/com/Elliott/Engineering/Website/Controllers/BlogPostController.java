package com.Elliott.Engineering.Website.Controllers;

import com.Elliott.Engineering.Website.Exceptions.BlogPostNotFound;
import com.Elliott.Engineering.Website.Exceptions.CalfNotFoundException;
import com.Elliott.Engineering.Website.Models.BlogPost;
import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
public class BlogPostController {

    @Autowired
    private BlogPostService service;

    @GetMapping("/getAll")
    public List<BlogPost> getAllCalves() throws BlogPostNotFound {

        List<BlogPost> blogPosts = service.getAllBlogPosts();

        return blogPosts;
    }

    @PostMapping("/save-post")
    public BlogPost savePost(@RequestBody BlogPost post){
        return service.saveBlogPost(post);
    }
}
