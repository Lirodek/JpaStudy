package com.example.commonweb.post;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void save(){
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);// persist

        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(savedPost == post).isTrue();

        Post postUpdate = new Post();
        post.setId(post.getId());
        post.setTitle("hibernate");
        Post updatePost = postRepository.save(post);// merge

        assertThat(entityManager.contains(updatePost)).isTrue();
        assertThat(entityManager.contains(postUpdate)).isFalse();
        assertThat(updatePost == postUpdate).isFalse();

        updatePost.setTitle("lirodek");

        List<Post> all = postRepository.findAll();
        all.forEach(System.out::println);
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartWith(){
        savePost();

        List<Post> all = postRepository.findByTitleStartingWith("Spring");
        all.forEach(System.out::println);
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitle(){
        savePost();

        List<Post> all = postRepository.findByTitle("Spring", JpaSort.unsafe("LENGTH(title)"));
        all.forEach(item-> log.info(item.toString()));
        assertThat(all.size()).isEqualTo(1);
    }

    private void savePost() {
        Post post = new Post();
        post.setTitle("Spring");
        Post savedPost = postRepository.save(post);// persist
    }

}