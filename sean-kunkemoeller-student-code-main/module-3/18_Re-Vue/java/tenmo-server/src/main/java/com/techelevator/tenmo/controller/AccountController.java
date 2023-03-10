package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/account")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class AccountController {

    private AccountDao accountDao;
    private UserDao userDao;

    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;

    }

    @RequestMapping( value = "/balance", method = RequestMethod.GET)
    public BigDecimal getBalance(Principal principal) throws UsernameNotFoundException {
        Long userId = getCurrentUserId(principal);
        return accountDao.getAccountByUserId(userId).getBalance();
    }

    /**
     * Finds the user by username and returns the id
     * @param principal the current authenticated user
     * @return Long user_id
     */
    private Long getCurrentUserId(Principal principal) {
        return userDao.findByUsername(principal.getName()).getId();
    }
}
