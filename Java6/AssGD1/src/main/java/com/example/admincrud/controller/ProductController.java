package com.example.admincrud.controller;
import com.example.admincrud.entity.*;
import com.example.admincrud.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService svc;
  public ProductController(ProductService svc){this.svc=svc;}
  @GetMapping public List<Product> all(){ return svc.findAll(); }
  @GetMapping("/{id}") public ResponseEntity<Product> get(@PathVariable Long id){ return svc.findById(id).map(ResponseEntity::ok).orElseThrow(()->new RuntimeException("Not found")); }
  @PostMapping public Product create(@Validated @RequestBody Product p){ return svc.createProduct(p); }
  @PutMapping("/{id}") public Product update(@PathVariable Long id, @RequestBody Product p){ return svc.updateProduct(id,p); }
  @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id){ svc.deleteProduct(id); return ResponseEntity.ok().build(); }
  // variant endpoints
  @PostMapping("/{productId}/variants") public ProductVariant addVariant(@PathVariable Long productId, @RequestBody ProductVariant v){ return svc.addVariant(productId,v); }
  @DeleteMapping("/variants/{id}") public ResponseEntity<?> deleteVariant(@PathVariable Long id){ svc.deleteVariant(id); return ResponseEntity.ok().build(); }
  // attribute endpoints
  @PostMapping("/attributes") public Attribute createAttribute(@RequestBody Attribute a){ return svc.createAttribute(a); }
  @DeleteMapping("/attributes/{id}") public ResponseEntity<?> deleteAttribute(@PathVariable Long id){ svc.deleteAttribute(id); return ResponseEntity.ok().build(); }
}
