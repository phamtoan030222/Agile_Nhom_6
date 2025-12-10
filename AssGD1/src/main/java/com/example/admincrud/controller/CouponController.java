package com.example.admincrud.controller;
import com.example.admincrud.entity.Coupon;
import com.example.admincrud.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/coupons")
public class CouponController {
  private final CouponService svc;
  public CouponController(CouponService svc){this.svc=svc;}
  @GetMapping public List<Coupon> all(){ return svc.findAll(); }
  @GetMapping("/{id}") public ResponseEntity<Coupon> get(@PathVariable Long id){ return svc.findById(id).map(ResponseEntity::ok).orElseThrow(()->new RuntimeException("Not found")); }
  @PostMapping public Coupon create(@Validated @RequestBody Coupon c){ return svc.create(c); }
  @PutMapping("/{id}") public Coupon update(@PathVariable Long id, @RequestBody Coupon c){ return svc.update(id,c); }
  @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id){ svc.delete(id); return ResponseEntity.ok().build(); }
}

