package com.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.ProductOwner;

@Repository
public interface ProductOwnerRepository extends JpaRepository<ProductOwner,Long>{

}
