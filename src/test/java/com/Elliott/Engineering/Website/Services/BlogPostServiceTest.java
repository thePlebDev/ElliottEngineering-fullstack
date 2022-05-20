package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Repositories.BlogPostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class BlogPostServiceTest {


    private BlogPostService underTest;


    @Mock
    private BlogPostRepository repository;


    @BeforeEach
    void init(){
        this.underTest = new BlogPostService(repository);
    }


}
