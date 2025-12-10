package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.example.demo.repo.*;
import com.example.demo.entity.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/ban")
@RequiredArgsConstructor
public class BanController {

 private final BanRepo repo;

 @GetMapping
 public List<Ban> getAll() {
  return repo.findAll();
 }

 @GetMapping("/page")
 public List<Ban> getPage(@RequestParam int page, @RequestParam int size) {
  return repo.findAll(org.springframework.data.domain.PageRequest.of(page, size))
          .getContent();
 }

 @PutMapping("/{id}")
 public ResponseEntity<Ban> update(@PathVariable Integer id, @RequestBody Ban b) {
  return repo.findById(id)
          .map(existing -> {

           existing.setMa(b.getMa());
           existing.setHoTen(b.getHoTen());
           existing.setEmail(b.getEmail());
           existing.setSoDienThoai(b.getSoDienThoai());
           existing.setNgaySinh(b.getNgaySinh());
           existing.setDiaChi(b.getDiaChi());
           existing.setNgayThamGia(b.getNgayThamGia());

           // update mối quan hệ
           if (b.getMoiQuanHe() != null) {
            existing.setMoiQuanHe(b.getMoiQuanHe());
           }

           return ResponseEntity.ok(repo.save(existing));
          })
          .orElseGet(() -> ResponseEntity.notFound().build());
 }

 @DeleteMapping("/{id}")
 public void delete(@PathVariable Integer id) {
  repo.deleteById(id);
 }
}
// get
//http://localhost:8080/api/ban

//lay danh sach phan trang
//http://localhost:8080/api/ban/page?page=0&size=5

//put Cập nhật 1 bạn theo ID
//http://localhost:8080/api/ban/1

/*{
  "ma": "B001",
  "hoTen": "Nguyễn Văn A Updated",
  "email": "emailnew@gmail.com",
  "soDienThoai": "0999999999",
  "ngaySinh": "1990-05-10",
  "diaChi": "Hà Nội",
  "ngayThamGia": "2020-03-12",
  "moiQuanHe": { "id": 1 }
}
*/

//Xóa 1 bạn theo ID
//http://localhost:8080/api/ban/4