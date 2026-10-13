package com.unam.apipizzasspringboot.controller;


import com.unam.apipizzasspringboot.dto.PizzaDTO;
import com.unam.apipizzasspringboot.model.Pizza;
import com.unam.apipizzasspringboot.service.IPIzzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pizzas")
@CrossOrigin(origins = "*")
public class PizzasRestController {
    @Autowired
    IPIzzaService service;
    @GetMapping("/getall")
    public ResponseEntity<?> getAllPizzas(){
        List<PizzaDTO> pizzasDTO = service.getPizzasServ();
        if(pizzasDTO.size()>0){
            return ResponseEntity
                    .status(200)
                    .body(pizzasDTO);
        }else{
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay pizzas");
        }
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getPizzaById(@PathVariable Long id){
        PizzaDTO pizzaDTO = service.getPizzaById(id);
        if(pizzaDTO==null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Id no encontrado");
        }
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(pizzaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePizzaById(@PathVariable Long id){
        if(service.deletePizzaById(id)==true){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Eliminado");
        }else{
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se puedo eliminar el elemento. Verifica Id!");
        }
    }

    @PostMapping
    public ResponseEntity<?> createPizza(@RequestBody PizzaDTO pizzaDTO){
        
        return null;
    }

}
