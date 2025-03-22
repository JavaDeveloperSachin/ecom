package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @NotBlank
    @Size(min = 3, message = "product name must contain atleast 3 characters")
    private String productName;
    @NotBlank
    @Size(min = 3, message = "product description must contain atleast 6 characters")
    private String description;
    private String image;
    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<CartItem> products = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product() {
    }


    public Product(Category category, String description, double discount, String image, double price, Integer productId, String productName, Integer quantity, double specialPrice) {
        this.category = category;
        this.description = description;
        this.discount = discount;
        this.image = image;
        this.price = price;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.specialPrice = specialPrice;
    }

    public Product(Category category, String description, double discount, String image, double price, Integer productId, String productName, Integer quantity, double specialPrice, User user) {
        this.category = category;
        this.description = description;
        this.discount = discount;
        this.image = image;
        this.price = price;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.specialPrice = specialPrice;
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }
}
