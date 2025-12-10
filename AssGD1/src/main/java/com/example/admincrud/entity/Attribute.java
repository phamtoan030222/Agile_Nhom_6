package com.example.admincrud.entity;
import jakarta.persistence.*;
@Entity
public class Attribute {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String value;
  public Attribute(){}
  public Attribute(String name,String value){this.name=name;this.value=value;}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String name){this.name=name;}
  public String getValue(){return value;} public void setValue(String value){this.value=value;}
}
