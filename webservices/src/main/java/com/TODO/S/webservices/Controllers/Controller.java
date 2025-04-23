package com.TODO.S.webservices.Controllers;

import com.TODO.S.webservices.Service.Services;
import com.TODO.S.webservices.TODOitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/TODO")
public class Controller {

    private final Services services;

    @Autowired
    Controller( Services services ){
        this.services = services;
    }

    @GetMapping("/list")
    public ArrayList<TODOitem> getTODOs(){
        return services.getList();
    }

    @PostMapping
    public TODOitem postTODo( @RequestBody TODOitem item ){
        return services.appendList(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTODO(@PathVariable String id){
        String res = services.deleteFromList(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
