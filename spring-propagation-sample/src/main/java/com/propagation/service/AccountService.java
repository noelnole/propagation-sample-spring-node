package com.propagation.service;

import com.propagation.model.Account;

/**
 * Created by noel on 6/02/17.
 */
public interface AccountService {

    public Account save(Account account);

    public Account findByUserId(String userId);
}
