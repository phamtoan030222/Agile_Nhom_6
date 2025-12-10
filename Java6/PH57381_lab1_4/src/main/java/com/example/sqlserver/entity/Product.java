package com.example.sqlserver.entity;
import jakarta.persistence.*;
@Entity
@Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String name;
 private Double price;
 private Integer quantity;
 @ManyToOne @JoinColumn(name="category_id")
 private Category category;
 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}
 public String getName(){return name;}
 public void setName(String n){this.name=n;}
 public Double getPrice(){return price;}
 public void setPrice(Double p){this.price=p;}
 public Integer getQuantity(){return quantity;}
 public void setQuantity(Integer q){this.quantity=q;}
 public Category getCategory(){return category;}
 public void setCategory(Category c){this.category=c;}
}
