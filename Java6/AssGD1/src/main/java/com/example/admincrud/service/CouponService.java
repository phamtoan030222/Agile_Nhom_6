package com.example.admincrud.service;
import com.example.admincrud.entity.Coupon;
import com.example.admincrud.exception.ResourceNotFoundException;
import com.example.admincrud.repository.CouponRepository;
import org.springframework.stereotype.Service;
import java.util.List; import java.util.Optional;
@Service
public class CouponService implements CrudService<Coupon> {
  private final CouponRepository repo;
  public CouponService(CouponRepository repo){this.repo=repo;}
  public List<Coupon> findAll(){return repo.findAll();}
  public Optional<Coupon> findById(Long id){return repo.findById(id);}
  public Coupon create(Coupon c){return repo.save(c);}
  public Coupon update(Long id, Coupon c){
    return repo.findById(id).map(existing->{ existing.setCode(c.getCode()); existing.setPercent(c.getPercent()); return repo.save(existing);})
      .orElseThrow(()->new ResourceNotFoundException("Coupon not found: "+id));
  }
  public void delete(Long id){ if(!repo.existsById(id)) throw new ResourceNotFoundException("Coupon not found: "+id); repo.deleteById(id);}
}
