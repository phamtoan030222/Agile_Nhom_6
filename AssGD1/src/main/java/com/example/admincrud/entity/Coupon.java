package com.example.admincrud.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Coupon {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  @Column(unique=true)
  private String code;
  private int percent;
  public Coupon(){}
  public Coupon(String code,int percent){this.code=code;this.percent=percent;}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getCode(){return code;} public void setCode(String code){this.code=code;}
  public int getPercent(){return percent;} public void setPercent(int percent){this.percent=percent;}
}
