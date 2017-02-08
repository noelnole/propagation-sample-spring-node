package com.propagation.model;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by noel on 6/02/17.
 */


@Document(collection = "accounts")
@Slf4j
public class Account {

    @Id
    public String id;

    public BigDecimal bugdet;

    @NotNull
    @NotEmpty
    public String userId;



    public Account(BigDecimal bugdet, String userId) {
        this.bugdet = bugdet;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", bugdet=" + bugdet +
                ", userId='" + userId + '\'' +
                '}';
    }
}
