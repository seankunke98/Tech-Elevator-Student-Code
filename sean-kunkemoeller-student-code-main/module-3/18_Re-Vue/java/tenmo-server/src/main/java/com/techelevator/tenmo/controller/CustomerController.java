package com.techelevator.tenmo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CustomerController {



}
