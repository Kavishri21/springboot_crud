package com.example_project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example_project.demo.Entity.userEntity;
//import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<userEntity,Long> {

}
