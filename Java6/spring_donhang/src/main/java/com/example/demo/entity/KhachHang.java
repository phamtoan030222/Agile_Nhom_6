package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class KhachHang {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer id;
 private String tenKhachHang;
 private String diaChi;
}
