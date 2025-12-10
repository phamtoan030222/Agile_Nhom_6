package com.example.admincrud.service;
import com.example.admincrud.entity.Employee;
import com.example.admincrud.exception.ResourceNotFoundException;
import com.example.admincrud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List; import java.util.Optional;
@Service
public class EmployeeService implements CrudService<Employee> {
  private final EmployeeRepository repo;
  public EmployeeService(EmployeeRepository repo){this.repo=repo;}
  public List<Employee> findAll(){return repo.findAll();}
  public Optional<Employee> findById(Long id){return repo.findById(id);}
  public Employee create(Employee e){return repo.save(e);}
  public Employee update(Long id, Employee e){
    return repo.findById(id).map(existing->{ existing.setName(e.getName()); existing.setRole(e.getRole()); return repo.save(existing);})
      .orElseThrow(()->new ResourceNotFoundException("Employee not found: "+id));
  }
  public void delete(Long id){ if(!repo.existsById(id)) throw new ResourceNotFoundException("Employee not found: "+id); repo.deleteById(id);}
}
