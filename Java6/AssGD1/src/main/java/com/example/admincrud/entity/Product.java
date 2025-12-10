package com.example.admincrud.entity;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ProductVariant> variants = new ArrayList<>();
  public Product(){}
  public Product(String name,String desc){this.name=name;this.description=desc;}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String name){this.name=name;}
  public String getDescription(){return description;} public void setDescription(String d){this.description=d;}
  public List<ProductVariant> getVariants(){return variants;} public void setVariants(List<ProductVariant> v){this.variants=v;}
  public void addVariant(ProductVariant v){variants.add(v); v.setProduct(this);}
  public void removeVariant(ProductVariant v){variants.remove(v); v.setProduct(null);}
}
