package com.example.demo.service;

import com.example.demo.entity.DonHang;

import java.util.List;

public interface DonHangService {

    List<DonHang> getAll();

    DonHang getById(Integer id);

    DonHang create(DonHang donHang);

    DonHang update(Integer id, DonHang donHang);

    void delete(Integer id);
}
