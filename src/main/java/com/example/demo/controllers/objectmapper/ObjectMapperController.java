package com.example.demo.controllers.objectmapper;

import com.example.demo.util.objectmapper.ObjectMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObjectMapperController {
    @Autowired
    ObjectMapperService objectMapperService;

    @GetMapping("/objectMapper")
    public String index(){
        objectMapperService.mapper();
        return "index";
    }
}
