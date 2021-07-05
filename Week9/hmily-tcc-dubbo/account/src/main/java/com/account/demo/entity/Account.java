package com.account.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author nikowang
 * @desc
 * @create 2021-07-05 11:09
 **/
@Data
public class Account implements Serializable {

    private Long id;

    private String name;

    private Long cny_wallet;

    private Long us_wallet;
}
