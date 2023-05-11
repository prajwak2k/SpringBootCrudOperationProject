package com.example.EmpSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmpSystem.entity.Category;
@Repository
public interface categoryRepository extends JpaRepository<Category, Integer> {

}
