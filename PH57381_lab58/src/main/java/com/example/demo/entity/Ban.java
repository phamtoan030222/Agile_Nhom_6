package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Ban {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 private String ma;
 private String hoTen;
 private String email;
 private String soDienThoai;
 private LocalDate ngaySinh;
 private String diaChi;
 private LocalDate ngayThamGia;

 @ManyToOne
 @JoinColumn(name = "moi_quan_he_id")
 private MoiQuanHe moiQuanHe;

 // ===== GETTER & SETTER =====

 public Integer getId() {
  return id;
 }

 // Không tạo setter ID vì ID tự tăng — tránh lỗi & không cho update ID
 // public void setId(Integer id) { this.id = id; }

 public String getMa() {
  return ma;
 }

 public void setMa(String ma) {
  this.ma = ma;
 }

 public String getHoTen() {
  return hoTen;
 }

 public void setHoTen(String hoTen) {
  this.hoTen = hoTen;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getSoDienThoai() {
  return soDienThoai;
 }

 public void setSoDienThoai(String soDienThoai) {
  this.soDienThoai = soDienThoai;
 }

 public LocalDate getNgaySinh() {
  return ngaySinh;
 }

 public void setNgaySinh(LocalDate ngaySinh) {
  this.ngaySinh = ngaySinh;
 }

 public String getDiaChi() {
  return diaChi;
 }

 public void setDiaChi(String diaChi) {
  this.diaChi = diaChi;
 }

 public LocalDate getNgayThamGia() {
  return ngayThamGia;
 }

 public void setNgayThamGia(LocalDate ngayThamGia) {
  this.ngayThamGia = ngayThamGia;
 }

 public MoiQuanHe getMoiQuanHe() {
  return moiQuanHe;
 }

 public void setMoiQuanHe(MoiQuanHe moiQuanHe) {
  this.moiQuanHe = moiQuanHe;
 }
}
