package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity(name = "categories")
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotBlank(message = "category name should be not blank")
    @Size(min = 5,message = "min 5 character required")
    private String categoryName;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category() {
    }

    public Category(String categoryName, Integer categoryId) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public @NotBlank(message = "category name should be not blank") @Size(min = 5, message = "min 5 character required") String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(@NotBlank(message = "category name should be not blank") @Size(min = 5, message = "min 5 character required") String categoryName) {
        this.categoryName = categoryName;
    }
}
