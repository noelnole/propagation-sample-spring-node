package com.propagation.repository;

import com.propagation.model.Account;
import org.springframework.data.repository.Repository;

/**
 * Created by noel on 6/02/17.
 */
public interface AccountRepository extends Repository<Account, String> {


    public Account findByUserId(String userId);

}
