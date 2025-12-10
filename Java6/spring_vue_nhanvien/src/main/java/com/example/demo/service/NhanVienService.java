package com.example.demo.service;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NhanVienService {
    private final NhanVienRepository repo;
    public NhanVienService(NhanVienRepository r){this.repo=r;}
    public List<NhanVien> findAll(){return repo.findAll();}
    public NhanVien findById(int id){return repo.findById(id).orElse(null);}
    public NhanVien save(NhanVien nv){return repo.save(nv);}
    public void delete(int id){repo.deleteById(id);}
}
