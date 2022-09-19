package com;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService service;
    @GetMapping("/parse-to-json")
    public StoreModel getAllProducts(){
        String path = "../ProductStore/moreInfo/main.html";
        return service.htmlToJson(path);
    }
}
