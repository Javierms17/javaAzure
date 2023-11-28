package com.crudazure.javaazure.controller;

import com.crudazure.javaazure.model.Operation;
import com.crudazure.javaazure.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fibo")
@CrossOrigin("*")
public class OperationController {

    @Autowired
    private IOperationService iOperationService;

    @GetMapping("/list")
    public ResponseEntity<List<Operation>> list(){
        var result = iOperationService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
