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
import com.example.EmpSystem.repository.categoryRepository;



@RestController

public class categoryController {
	
	
	@Autowired
	private categoryRepository repository;
	
@PostMapping("/categories")
public Category saveCategories(@RequestBody Category categorys) {
	return repository.save(categorys);
}


@GetMapping("/categories/{cid}")
public Optional<Category> findbyId(@PathVariable("cid") int id)
{
	return repository.findById(id);

}

@PutMapping("/categories/update/{cid}")
public Optional <Category> updateCategory(@PathVariable ("cid")int id,@RequestBody Category category ) {
		repository.save(category);
	return repository.findById(category.getCid());
}
@DeleteMapping("/categories/delete/{cid}")
public void deletebyId(@PathVariable("cid") int id) {
	repository.deleteById(id);
	System.out.println("Category Delete Sucessfully");
}
@GetMapping("/category/pages")
public List<Category> getAll(@RequestParam (value = "page",defaultValue = "0") int page,@RequestParam(value ="pageSize") Integer pageSize){
	
	Page<Category>page2 = repository.findAll(PageRequest.of(page, pageSize));
	List<Category> list1=page2.getContent();
	return list1;
}




















}
