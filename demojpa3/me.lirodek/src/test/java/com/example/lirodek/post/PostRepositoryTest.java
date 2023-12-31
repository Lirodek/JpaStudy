package com.example.lirodek.post;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Import(PostRepositoryTestConfig.class)
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void crud(){
        Post post = new Post();
        post.setTitle("hibernate");
        postRepository.save(post.publish());

        Predicate predicate = QPost.post.title.containsIgnoreCase("Hi");
        Optional<Post> one = postRepository.findOne(predicate);
        assertThat(one).isNotEmpty();
    }

}