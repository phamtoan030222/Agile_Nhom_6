package com.example.admincrud.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Employee {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String name;
  private String role;
  public Employee(){}
  public Employee(String name, String role){this.name=name; this.role=role;}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String name){this.name=name;}
  public String getRole(){return role;} public void setRole(String role){this.role=role;}
}
