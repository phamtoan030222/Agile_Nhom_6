package com.example.admincrud.controller;
import com.example.admincrud.entity.DiscountCampaign;
import com.example.admincrud.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/discounts")
public class DiscountController {
  private final DiscountService svc;
  public DiscountController(DiscountService svc){this.svc=svc;}
  @GetMapping public List<DiscountCampaign> all(){ return svc.findAll(); }
  @GetMapping("/{id}") public ResponseEntity<DiscountCampaign> get(@PathVariable Long id){ return svc.findById(id).map(ResponseEntity::ok).orElseThrow(()->new RuntimeException("Not found")); }
  @PostMapping public DiscountCampaign create(@Validated @RequestBody DiscountCampaign d){ return svc.create(d); }
  @PutMapping("/{id}") public DiscountCampaign update(@PathVariable Long id, @RequestBody DiscountCampaign d){ return svc.update(id,d); }
  @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id){ svc.delete(id); return ResponseEntity.ok().build(); }
}
