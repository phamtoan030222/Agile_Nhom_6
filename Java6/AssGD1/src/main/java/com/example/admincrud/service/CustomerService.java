package com.example.admincrud.service;
import com.example.admincrud.entity.Customer;
import com.example.admincrud.exception.ResourceNotFoundException;
import com.example.admincrud.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements CrudService<Customer> {
  private final CustomerRepository repo;
  public CustomerService(CustomerRepository repo){this.repo=repo;}
  public List<Customer> findAll(){return repo.findAll();}
  public Optional<Customer> findById(Long id){return repo.findById(id);}
  public Customer create(Customer c){return repo.save(c);}
  public Customer update(Long id, Customer c){
    return repo.findById(id).map(existing->{
      existing.setName(c.getName());
      existing.setEmail(c.getEmail());
      existing.setPhone(c.getPhone());
      return repo.save(existing);
    }).orElseThrow(()->new ResourceNotFoundException("Customer not found: "+id));
  }
  public void delete(Long id){
    if(!repo.existsById(id)) throw new ResourceNotFoundException("Customer not found: "+id);
    repo.deleteById(id);
  }
}
