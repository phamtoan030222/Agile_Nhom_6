package com.example.admincrud.controller;
import com.example.admincrud.entity.Employee;
import com.example.admincrud.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
  private final EmployeeService svc;
  public EmployeeController(EmployeeService svc){this.svc=svc;}
  @GetMapping public List<Employee> all(){ return svc.findAll(); }
  @GetMapping("/{id}") public ResponseEntity<Employee> get(@PathVariable Long id){ return svc.findById(id).map(ResponseEntity::ok).orElseThrow(()->new RuntimeException("Not found")); }
  @PostMapping public Employee create(@Validated @RequestBody Employee e){ return svc.create(e); }
  @PutMapping("/{id}") public Employee update(@PathVariable Long id, @RequestBody Employee e){ return svc.update(id,e); }
  @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id){ svc.delete(id); return ResponseEntity.ok().build(); }
}
