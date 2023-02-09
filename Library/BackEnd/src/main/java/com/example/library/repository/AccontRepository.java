package com.example.library.repository;

import com.example.library.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccontRepository extends JpaRepository<Account, Long> {

    List<Account> findByuserName(String userName);

}
