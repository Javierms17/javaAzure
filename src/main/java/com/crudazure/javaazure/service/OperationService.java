package com.crudazure.javaazure.service;

import com.crudazure.javaazure.model.Operation;
import com.crudazure.javaazure.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService implements IOperationService {

    @Autowired
    private IOperationRepository iOperationRepository;

    @Override
    public List<Operation> findAll() {
        List<Operation> list;
        try{
            list = iOperationRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
        return  list;
    }

    @Override
    public Operation findByPos(int pos) {
        Operation op;
        try{
            op= iOperationRepository.findByPos(pos);
        } catch (Exception e) {
            throw e;
        }
        return  op;
    }

    @Override
    public int save(Operation op) {
        int row;
        try{
            row = iOperationRepository.save(op);
        } catch (Exception e) {
            throw e;
        }

        return row;
    }

    @Override
    public List<Operation> findTop10Operations() {
        // Puedes implementar lógica para obtener las 10 operaciones más consultadas
        // Aquí asumiré que simplemente se devuelven todas las operaciones ordenadas por count de forma descendente.
        return iOperationRepository.findTop10ByOrderByCountDesc();
    }
    @Override
    public int update(Operation op) {
        int row;
        try {
            row = iOperationRepository.update(op);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }
}
