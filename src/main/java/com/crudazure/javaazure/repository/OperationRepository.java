package com.crudazure.javaazure.repository;

import com.crudazure.javaazure.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OperationRepository implements IOperationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Operation> findAll() {
        String SQL = "SELECT * FROM Operation";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Operation.class));
    }

    @Override
    public int save(Operation op) {
        String SQL = "INSERT INTO Operation VALUES(?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{op.getPos(),op.getCount(),op.getResult()});
    }

    @Override
    public int update(Operation op) {
        String SQL = "UPDATE Operation SET pos=?, count=?,result=? WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{op.getPos(), op.getCount(),op.getResult(),op.getId()});
    }
}
