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

    @GetMapping("/top10")
    public ResponseEntity<List<Operation>> getTop10Operations() {
        List<Operation> top10Operations = iOperationService.findTop10Operations();
        return new ResponseEntity<>(top10Operations, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Operation>> list(){
        var result = iOperationService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getbypos/{pos}")
    public ResponseEntity<Operation> getopbyid(@PathVariable int pos){
        var result = iOperationService.findByPos(pos);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/calculate/{pos}")
    public ResponseEntity<Integer> calculate(@PathVariable int pos){

        if (pos < 0) {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }

        if (pos == 0) {
            var op = iOperationService.findByPos(pos);

            if(op==null){

                Operation opn = new Operation();
                opn.setPos(pos);
                opn.setCount(1);
                opn.setResult(0);
                int nueva= iOperationService.save(opn);
            }else{
                op.setCount(op.getCount() + 1);
                int exist = iOperationService.update(op);
            }
          return  new ResponseEntity<>(0, HttpStatus.OK);
        }

        if (pos == 1) {
            var op = iOperationService.findByPos(pos);

            if(op==null){

                Operation opn = new Operation();
                opn.setPos(pos);
                opn.setCount(1);
                opn.setResult(1);
                int nueva= iOperationService.save(opn);
            }else{
                op.setCount(op.getCount() + 1);
                int exist = iOperationService.update(op);
            }
            return new ResponseEntity<>(1, HttpStatus.OK);
        }

        int fibAnterior = 0;
        int fibActual = 1;

        for (int i = 2; i <= pos; i++) {
            int temp = fibActual;
            fibActual = fibAnterior + fibActual;
            fibAnterior = temp;
        }
        if(pos>=0){

            var op = iOperationService.findByPos(pos);

           if(op==null){

               Operation opn = new Operation();
               opn.setPos(pos);
               opn.setCount(1);
               opn.setResult(fibActual);
               int nueva= iOperationService.save(opn);
           }else{
                   op.setCount(op.getCount() + 1);
                   int exist = iOperationService.update(op);
           }
        }
        return new ResponseEntity<>(fibActual, HttpStatus.OK);
    }


}
