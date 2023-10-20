package me.lirodek.demospringdata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;





@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crudRepository(){
        // GIVEN
        Post post = new Post();
        post.setTitle("hello Spring boot common");
        assertThat(post.getId()).isNull();

        // WHEN
        Post newPost = postRepository.save(post);

        // THEN
        assertThat(newPost.getId()).isNotNull();
    }

}