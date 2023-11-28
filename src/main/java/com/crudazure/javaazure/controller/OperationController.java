package com.crudazure.javaazure.controller;

import com.crudazure.javaazure.model.Operation;
import com.crudazure.javaazure.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/calculate/{pos}")
    public ResponseEntity<Integer> calculate(@PathVariable int pos){

        if (pos < 0) {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }

        if (pos == 0) {
          return  new ResponseEntity<>(0, HttpStatus.OK);
        }

        if (pos == 1) {
            return new ResponseEntity<>(1, HttpStatus.OK);
        }

        int fibAnterior = 0;
        int fibActual = 1;

        for (int i = 2; i <= pos; i++) {
            int temp = fibActual;
            fibActual = fibAnterior + fibActual;
            fibAnterior = temp;
        }

        return new ResponseEntity<>(fibActual, HttpStatus.OK);
    }


}
