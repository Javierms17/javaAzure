package com.crudazure.javaazure.repository;

import com.crudazure.javaazure.model.Operation;

import java.util.List;

public interface IOperationRepository {
    // Código de la clase Repository
    public List<Operation> findAll();
    public int save(Operation op);
    public int update(Operation op);
}