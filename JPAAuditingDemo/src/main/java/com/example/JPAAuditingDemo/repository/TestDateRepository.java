package com.example.JPAAuditingDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JPAAuditingDemo.model.TestDateEntity;

@Repository
public interface TestDateRepository extends JpaRepository<TestDateEntity, Integer> {

}
