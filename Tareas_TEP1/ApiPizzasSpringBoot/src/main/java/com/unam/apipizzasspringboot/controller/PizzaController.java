package com.unam.apipizzasspringboot.controller;

import com.unam.apipizzasspringboot.service.IPIzzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// Para vista. Aun por terminar
@Controller
public class PizzaController {
    @Autowired
    IPIzzaService service;


    @GetMapping("/")
    public String index(){
        return "index";
    }
}
