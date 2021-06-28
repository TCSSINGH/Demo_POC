package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CustomerModel;
@Repository
public interface CustomerDao extends JpaRepository<CustomerModel, Integer> {

}
