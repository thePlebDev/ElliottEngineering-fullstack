package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.BlogPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class BlogPostRepositoryTest {

    @Autowired
    private BlogPostRepository underTest;



    @Test
    public void getBlogPostByIdTest(){
        //GIVEN
        BlogPost post = new BlogPost("another","one");

        //WHEN
        underTest.save(post);
        BlogPost returnedBlogPost = underTest.getBlogPostById(1l).get();

        //THEN
        assertThat(returnedBlogPost.getId()).isEqualTo(1);

    }

    @Test
    public void getBlogPostByTitle(){
        //GIVEN
        final String EXPECTED_TITLE = "THIS IS THE EXPECTED TITLE";
        BlogPost post = new BlogPost(EXPECTED_TITLE,"one");

        //WHEN
        underTest.save(post);
        BlogPost returnedBlogPost = underTest.getByTitle(EXPECTED_TITLE).get();

        //THEN
        assertThat(returnedBlogPost.getTitle()).isEqualTo(EXPECTED_TITLE);
    }

    @Test
    public void getByDateLatestTest(){
        //GIVEN
        BlogPost post = new BlogPost("another","one");
        BlogPost post1 = new BlogPost("another","one");

        //WHEN
        underTest.save(post);
        underTest.save(post1);
        List<BlogPost> returnedBlogPost = underTest.getByDateLatest().get();

        assertThat(returnedBlogPost.size()).isEqualTo(2);

    }
}
