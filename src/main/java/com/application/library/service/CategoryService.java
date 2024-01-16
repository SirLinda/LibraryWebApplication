package com.application.library.service;

import com.application.library.entity.Category;
import com.application.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NamingEnumeration;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCatagories(){
        return categoryRepository.findAll();
    }

    public Category findCatergoryById(Long categoryId){
        Category category;
        category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Catergory not found"));
        return category;
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }
    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long categoryId){
        Category category;
        category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
        //categoryRepository.deleteById(categoryId);
    }
}
