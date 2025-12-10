package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "don_hang")
public class DonHang {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @ManyToOne
 @JoinColumn(name = "khach_hang_id")
 private KhachHang khachHang;

 @Column(name = "ma_don_hang")
 private String maDonHang;

 @Column(name = "ngay_dat")
 private LocalDate ngayDat;

 @Column(name = "tong_tien")
 private Double tongTien;

 @Column(name = "dia_chi_giao")
 private String diaChiGiao;

 @Column(name = "so_dien_thoai_giao")
 private String soDienThoaiGiao;

 @Column(name = "ghi_chu")
 private String ghiChu;

 @Column(name = "trang_thai")
 private String trangThai;

 @Column(name = "nguoi_xu_ly")
 private String nguoiXuLy;
}
