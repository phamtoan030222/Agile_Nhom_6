package com.example.admincrud.service;
import com.example.admincrud.entity.DiscountCampaign;
import com.example.admincrud.exception.ResourceNotFoundException;
import com.example.admincrud.repository.DiscountRepository;
import org.springframework.stereotype.Service;
import java.util.List; import java.util.Optional;
@Service
public class DiscountService implements CrudService<DiscountCampaign> {
  private final DiscountRepository repo;
  public DiscountService(DiscountRepository repo){this.repo=repo;}
  public List<DiscountCampaign> findAll(){return repo.findAll();}
  public Optional<DiscountCampaign> findById(Long id){return repo.findById(id);}
  public DiscountCampaign create(DiscountCampaign d){return repo.save(d);}
  public DiscountCampaign update(Long id, DiscountCampaign d){
    return repo.findById(id).map(existing->{ existing.setName(d.getName()); existing.setStartDate(d.getStartDate()); existing.setEndDate(d.getEndDate()); return repo.save(existing);})
      .orElseThrow(()->new ResourceNotFoundException("Discount not found: "+id));
  }
  public void delete(Long id){ if(!repo.existsById(id)) throw new ResourceNotFoundException("Discount not found: "+id); repo.deleteById(id);}
}
