package com.TODO.S.webservices.Controllers;

import com.TODO.S.webservices.Service.Services;
import com.TODO.S.webservices.TODOitem;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/TODO")
@AllArgsConstructor
public class Controller {

    private final Services services;

    @GetMapping("/list")
    public ArrayList<TODOitem> getTODOs(){
        return services.getList();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> postTODo( @RequestBody TODOitem item ){

        TODOitem resItem = services.appendList(item);

        if(resItem == null){
            ApiResponse<TODOitem> response = new ApiResponse<>("TODO Couldn't Create","fail", resItem);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }else{
            ApiResponse<TODOitem> response = new ApiResponse<>("TODO created","success", resItem);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteTODO(@PathVariable String id){
        String res = services.deleteFromList(id);
        if(res.equals("error occurs")){
            ApiResponse<String > response = new ApiResponse<>("TODO Couldn't delete","fail", res);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }else{
            ApiResponse<String > response = new ApiResponse<>("TODO created","success", res);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }    }
}
