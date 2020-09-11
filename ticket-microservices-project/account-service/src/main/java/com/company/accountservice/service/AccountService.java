package com.company.accountservice.service;

import com.company.accountservice.entity.Account;
import com.company.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Optional<Account> get(String id) {
        return accountRepository.findById(id);
    }


    public Account save(Account account) {
        return accountRepository.save(account);

    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }

    public void delete(String id) {
        accountRepository.deleteById(id);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }


}
