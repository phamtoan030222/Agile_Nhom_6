package com.example.demo.controller;

import com.example.demo.entity.DonHang;
import com.example.demo.repo.DonHangRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donhang")
@RequiredArgsConstructor
public class DonHangController {
 private final DonHangRepo repo;

 @GetMapping
 public List<Map<String,Object>> getAll(){
   return repo.findAll().stream().map(d-> Map.of(
     "id", d.getId(),
     "maDonHang", d.getMaDonHang(),
     "ngayDat", d.getNgayDat().toString(),
     "tongTien", d.getTongTien(),
     "tenKhachHang", d.getKhachHang().getTenKhachHang(),
     "diaChi", d.getKhachHang().getDiaChi()
   )).toList();
 }

 @PostMapping
 public DonHang add(@RequestBody DonHang d){ return repo.save(d); }

 @PutMapping("/{id}")
 public DonHang update(@PathVariable Integer id,@RequestBody DonHang d){
   d.setId(id);
   return repo.save(d);
 }

 @DeleteMapping("/{id}")
 public void delete(@PathVariable Integer id){ repo.deleteById(id); }
}
