package com.example.lirodek.post;

import com.example.lirodek.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends MyRepository<Post, Long>, QuerydslPredicateExecutor<Post> {


}
