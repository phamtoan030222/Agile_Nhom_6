package com.example.demo.entity;
import jakarta.persistence.*;import java.time.LocalDate;
@Entity public class MoiQuanHe{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
 private String ma; private String loaiQuanHe; private LocalDate ngayBatDau;
 //get/set
}