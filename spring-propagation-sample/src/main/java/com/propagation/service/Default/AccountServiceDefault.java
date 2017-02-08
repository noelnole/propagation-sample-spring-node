package com.propagation.service.Default;

import com.propagation.model.Account;
import com.propagation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by noel on 6/02/17.
 */
public class AccountServiceDefault implements AccountService{

    private static AccountService accountService;

    @Autowired
    public AccountServiceDefault (AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public Account save(Account account) {
       return accountService.save(account);
    }

    @Override
    public Account findByUserId(String userId) {
        return accountService.findByUserId(userId);
    }
}
