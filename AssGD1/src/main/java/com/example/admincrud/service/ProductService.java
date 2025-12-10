package com.example.admincrud.service;
import com.example.admincrud.entity.*;
import com.example.admincrud.exception.ResourceNotFoundException;
import com.example.admincrud.repository.*;
import org.springframework.stereotype.Service;
import java.util.List; import java.util.Optional;
@Service
public class ProductService {
  private final ProductRepository productRepo;
  private final VariantRepository variantRepo;
  private final AttributeRepository attrRepo;
  public ProductService(ProductRepository p, VariantRepository v, AttributeRepository a){this.productRepo=p;this.variantRepo=v;this.attrRepo=a;}
  public List<Product> findAll(){ return productRepo.findAll(); }
  public Optional<Product> findById(Long id){ return productRepo.findById(id); }
  public Product createProduct(Product p){ 
    // cascade will save variants if attached
    return productRepo.save(p);
  }
  public Product updateProduct(Long id, Product p){
    return productRepo.findById(id).map(existing->{
      existing.setName(p.getName()); existing.setDescription(p.getDescription());
      return productRepo.save(existing);
    }).orElseThrow(()->new ResourceNotFoundException("Product not found: "+id));
  }
  public void deleteProduct(Long id){
    if(!productRepo.existsById(id)) throw new ResourceNotFoundException("Product not found: "+id);
    productRepo.deleteById(id);
  }
  // Variant operations
  public ProductVariant addVariant(Long productId, ProductVariant v){
    Product product = productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product not found: "+productId));
    product.addVariant(v);
    productRepo.save(product);
    return v;
  }
  public void deleteVariant(Long id){ if(!variantRepo.existsById(id)) throw new ResourceNotFoundException("Variant not found: "+id); variantRepo.deleteById(id);}
  // Attribute operations
  public Attribute createAttribute(Attribute a){ return attrRepo.save(a); }
  public void deleteAttribute(Long id){ if(!attrRepo.existsById(id)) throw new ResourceNotFoundException("Attribute not found: "+id); attrRepo.deleteById(id);}
}
