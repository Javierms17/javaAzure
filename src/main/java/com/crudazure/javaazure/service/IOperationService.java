package com.crudazure.javaazure.service;

import com.crudazure.javaazure.model.Operation;

import java.util.List;

public interface IOperationService {
    public List<Operation> findAll();
    public int save(Operation op);
    public int update(Operation op);
}
