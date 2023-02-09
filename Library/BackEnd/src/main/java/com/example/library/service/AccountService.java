package com.example.library.service;

import com.example.library.model.Account;
import com.example.library.repository.AccontRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Resource
    AccontRepository accontRepository;

    public Optional<Account> getAccount(Long id) {
        return accontRepository.findById(id);
    }

    public Long createAccount(Account account) {
        List<Account> accounts = accontRepository.findByuserName(account.getUserName());


        if (accounts.isEmpty()) {

            return accontRepository.save(account).getId();

        } else {
            return Long.valueOf(-1);
        }
    }

    public Long loginAccount(Account account) {
        List<Account> accounts = accontRepository.findByuserName(account.getUserName());

        if (!accounts.isEmpty() & accounts.get(0).getPassword().equals(account.getPassword())) {
            return accounts.get(0).getId();

        } else {
            return Long.valueOf(-1);
        }
    }

}
