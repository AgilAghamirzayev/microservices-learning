package com.company.accountservice.service;

import com.company.accountservice.dto.AccountDto;
import com.company.accountservice.entity.Account;
import com.company.accountservice.exception.AccountNotFoundException;
import com.company.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;


    public AccountDto get(String id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> {
            throw new AccountNotFoundException(String.format("Account not found id: %s", id));
        });
        return modelMapper.map(account, AccountDto.class);
    }

    @Transactional
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Optional<Account> foundedAccount = accountRepository.findById(id);
        Account accountToUpdate = foundedAccount.map(account -> {
            account.setBirthDate(accountDto.getBirthDate());
            account.setName(accountDto.getName());
            account.setSurname(accountDto.getSurname());
            account.setEmail(accountDto.getEmail());
            account.setUsername(accountDto.getUsername());
            account.setPassword(accountDto.getPassword());
            return account;
        }).orElseThrow(() -> {
            throw new AccountNotFoundException(String.format("Account not found id: %s", id));
        });
        return modelMapper.map(accountRepository.save(accountToUpdate), AccountDto.class);
    }

    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> {
                    throw new AccountNotFoundException(String.format("Account not found id: %s", id));
                });
        accountRepository.delete(account);
    }

    public Page<AccountDto> findAll(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);
        return null;
    }
}