package me.lirodek.demospringdata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws ExecutionException, InterruptedException {
        this.createComment(100, "spring data jpa");
        this.createComment(55, "HIBERNATE SPRING");


        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));

        ListenableFuture<List<Comment>> future =
                commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        System.out.println("==========");
        System.out.println("id done ? " +  future.isDone());


        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }

            @Override
            public void onSuccess(@Nullable List<Comment> result) {
                System.out.println("==== Async ====");
                result.forEach(System.out::println);
            }
        });

        Thread.sleep(50000l);
    }

    private void createComment(int likeCount, String commentString) {
        Comment comment = new Comment();
        comment.setComment(commentString);
        comment.setLikeCount(likeCount);
        commentRepository.save(comment);
    }
}