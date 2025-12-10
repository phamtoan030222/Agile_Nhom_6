package com.example.admincrud.controller;
import com.example.admincrud.entity.Customer;
import com.example.admincrud.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
  private final CustomerService svc;
  public CustomerController(CustomerService svc){this.svc=svc;}
  @GetMapping public List<Customer> all(){ return svc.findAll(); }
  @GetMapping("/{id}") public ResponseEntity<Customer> get(@PathVariable Long id){ return svc.findById(id).map(ResponseEntity::ok).orElseThrow(()->new RuntimeException("Not found")); }
  @PostMapping public Customer create(@Validated @RequestBody Customer c){ return svc.create(c); }
  @PutMapping("/{id}") public Customer update(@PathVariable Long id, @RequestBody Customer c){ return svc.update(id,c); }
  @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id){ svc.delete(id); return ResponseEntity.ok().build(); }
}
