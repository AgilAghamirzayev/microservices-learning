package com.company.accountservice.api;

import com.company.accountservice.dto.AccountDto;
import com.company.accountservice.entity.Account;
import com.company.accountservice.exception.AccountNotFoundException;
import com.company.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountApi {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.update(id, account));
    }

    @DeleteMapping
    public void delete(String id) {
        accountService.delete(id);
    }

    @GetMapping
    public ResponseEntity<Page<AccountDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(accountService.findAll(pageable));
    }
}
