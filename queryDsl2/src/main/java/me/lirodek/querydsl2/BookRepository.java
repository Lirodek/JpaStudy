package me.lirodek.querydsl2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookRepository extends CustomRepository<Book, Long>, QuerydslPredicateExecutor<Book>, JpaRepository<Book, Long> {
}
