package com.example.EmpSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmpSystem.entity.Category;
import com.example.EmpSystem.entity.Products;
import com.example.EmpSystem.repository.productRepository;
@RestController
public class productController {
	@Autowired
	private productRepository repository;
	
	@PostMapping("/products")
	public Products saveProducts(@RequestBody Products products) {
		return repository.save(products);
	}
	@GetMapping("/products/{pid}")
	public Optional<Products> getById(@PathVariable("pid") int id) {
		return repository.findById(id);
		
	}
	@PutMapping("/products/update/{pid}")
	public Optional <Products> updateCategory( @PathVariable("pid") int pid ,@RequestBody Products products ) {
			repository.save(products);
		return repository.findById(products.getPid());
	}
	@DeleteMapping("/products/delete/{pid}")
	public void deletebyId(@PathVariable("pid") int id) {
		repository.deleteById(id);
		System.out.println("Products Are Deleted Sucessfully");
	}
	@GetMapping("/products/page")
	public List<Products> getAll(@RequestParam (value = "page",defaultValue = "0") int page,@RequestParam(value ="pageSize") Integer pageSize){
		
		Page<Products>page2 = repository.findAll(PageRequest.of(page, pageSize));
		List<Products> list=page2.getContent();
		return list;
	}
	
}











