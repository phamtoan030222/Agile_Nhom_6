package com.example.demo.controller;

import com.example.demo.entity.DonHang;
import com.example.demo.service.DonHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donhang")
@RequiredArgsConstructor
public class DonHangController {

    private final DonHangService service;

    @GetMapping
    public List<DonHang> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DonHang getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public DonHang create(@RequestBody DonHang donHang) {
        return service.create(donHang);
    }

    @PutMapping("/{id}")
    public DonHang update(@PathVariable Integer id, @RequestBody DonHang donHang) {
        return service.update(id, donHang);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
