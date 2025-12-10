package com.example.admincrud.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class DiscountCampaign {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private LocalDate startDate;
  private LocalDate endDate;
  public DiscountCampaign(){}
  public DiscountCampaign(String name, LocalDate s, LocalDate e){this.name=name; this.startDate=s; this.endDate=e;}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String name){this.name=name;}
  public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate d){this.startDate=d;}
  public LocalDate getEndDate(){return endDate;} public void setEndDate(LocalDate d){this.endDate=d;}
}
