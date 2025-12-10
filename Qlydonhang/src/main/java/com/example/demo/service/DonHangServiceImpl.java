package com.example.demo.service;

import com.example.demo.entity.DonHang;
import com.example.demo.repo.DonHangRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonHangServiceImpl implements DonHangService {

    private final DonHangRepo repo;

    @Override
    public List<DonHang> getAll() {
        return repo.findAll();
    }

    @Override
    public DonHang getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public DonHang create(DonHang donHang) {
        return repo.save(donHang);
    }

    @Override
    public DonHang update(Integer id, DonHang donHang) {
        DonHang old = repo.findById(id).orElse(null);
        if (old == null) return null;

        donHang.setId(id);
        return repo.save(donHang);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
