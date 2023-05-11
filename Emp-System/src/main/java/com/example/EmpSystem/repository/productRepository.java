package com.example.EmpSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmpSystem.entity.Products;
@Repository
public interface productRepository extends JpaRepository<Products, Integer>{

}
