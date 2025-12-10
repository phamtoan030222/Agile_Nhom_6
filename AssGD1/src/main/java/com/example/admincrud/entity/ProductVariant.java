package com.example.admincrud.entity;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class ProductVariant {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String sku;
  private double price;
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "variant_attribute",
     joinColumns = @JoinColumn(name="variant_id"),
     inverseJoinColumns = @JoinColumn(name="attribute_id"))
  private Set<Attribute> attributes = new HashSet<>();
  public ProductVariant(){}
  public ProductVariant(String sku,double price){this.sku=sku;this.price=price;}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getSku(){return sku;} public void setSku(String s){this.sku=s;}
  public double getPrice(){return price;} public void setPrice(double p){this.price=p;}
  public Product getProduct(){return product;} public void setProduct(Product p){this.product=p;}
  public Set<Attribute> getAttributes(){return attributes;} public void setAttributes(Set<Attribute> a){this.attributes=a;}
}
