package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity @Data
public class DonHang {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer id;
 private String maDonHang;
 private LocalDate ngayDat;
 private Long tongTien;

 @ManyToOne
 @JoinColumn(name="khachhang_id")
 private KhachHang khachHang;
}
