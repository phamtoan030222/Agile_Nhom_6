package com.example.demo.controller;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.NhanVienService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/nhanvien")
public class NhanVienController {
    private final NhanVienService service;
    public NhanVienController(NhanVienService s){this.service=s;}

    @GetMapping
    public List<NhanVien> getAll(){return service.findAll();}

    @GetMapping("/{id}")
    public NhanVien getOne(@PathVariable int id){return service.findById(id);}

    @PostMapping
    public NhanVien add(@RequestBody NhanVien nv){return service.save(nv);}

    @PutMapping("/{id}")
    public NhanVien update(@PathVariable int id,@RequestBody NhanVien nv){
        nv.setId(id);
        return service.save(nv);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){service.delete(id);}
}
