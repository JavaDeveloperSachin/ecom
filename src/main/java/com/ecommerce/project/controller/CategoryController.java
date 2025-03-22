package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/api/public/categories")
    public ResponseEntity<CategoryResponse> getCategories(
            @RequestParam(name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(name = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(name="sortBy",defaultValue =AppConstants.SORT_CATEGORIES_BY,required = false ) String sortBy,
            @RequestParam(name="sortOrder",defaultValue = AppConstants.SORT_ORDER,required = false) String sortOrder
    ) {
        CategoryResponse allCategories = categoryService.getAllCategories(pageNumber,pageSize,sortBy,sortOrder);
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<CategoryDTO> addCatrgories(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategoryDTO = categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/public/categories/{categoryID}")
    public ResponseEntity<CategoryDTO> deleteCategoey(@PathVariable Integer categoryID) {
        CategoryDTO deleteCategory = categoryService.deleteCategory(categoryID);
        return new ResponseEntity<CategoryDTO>(deleteCategory, HttpStatus.OK);
    }

    @PutMapping("/api/public/categories/{categoryID}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryID) {
        CategoryDTO UpdatedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryID);
        return new ResponseEntity<>(UpdatedCategoryDTO, HttpStatus.OK);
    }

}
