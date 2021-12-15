package com.cocktail.controller;

import com.cocktail.common.exception.NotFoundException;
import com.cocktail.dto.ResponseMessage;
import com.cocktail.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<ResponseMessage> findById(@RequestParam Long id) {
        return ResponseEntity.ok(new ResponseMessage(ingredientService.findById(id).orElseThrow(NotFoundException::new)));
    }


}
