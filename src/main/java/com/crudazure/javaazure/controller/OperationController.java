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
    public int calculate(@PathVariable int pos){

        if (pos < 0) {
            throw new IllegalArgumentException("La posición debe ser un número no negativo");
        }

        if (pos == 0) {
            return 0;
        }

        if (pos == 1) {
            return 1;
        }

        int fibAnterior = 0;
        int fibActual = 1;

        for (int i = 2; i <= pos; i++) {
            int temp = fibActual;
            fibActual = fibAnterior + fibActual;
            fibAnterior = temp;
        }

        return fibActual;
    }


}
