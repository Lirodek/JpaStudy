package me.lirodek.querydsl2;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> {
    boolean contains(T entity);
}
