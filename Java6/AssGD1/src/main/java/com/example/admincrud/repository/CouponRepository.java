package com.example.admincrud.repository;
import com.example.admincrud.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CouponRepository extends JpaRepository<Coupon, Long>{}
