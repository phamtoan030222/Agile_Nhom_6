package com.example.admincrud.repository;
import com.example.admincrud.entity.DiscountCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DiscountRepository extends JpaRepository<DiscountCampaign, Long>{}
