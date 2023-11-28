package com.crudazure.javaazure.service;

import com.crudazure.javaazure.model.Operation;

import java.util.List;

public interface IOperationService {
    public List<Operation> findAll();

   public Operation findByPos(int pos);

    public int save(Operation op);

    List<Operation> findTop10Operations();

    public int update(Operation op);
}
