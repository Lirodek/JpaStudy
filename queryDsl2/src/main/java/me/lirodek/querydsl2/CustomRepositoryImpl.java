package me.lirodek.querydsl2;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;

public class CustomRepositoryImpl<T, ID extends Serializable> extends QuerydslJpaRepository<T, ID> implements CustomRepository<T, ID> {

    EntityManager entityManager;

    public CustomRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }
}
