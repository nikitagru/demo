package com.example.demo.services;

import com.example.demo.enitites.Table;
import com.example.demo.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    private TableRepository tableRepository;

    @Autowired
    public void setTableRepository(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<Table> getAll() {
        return tableRepository.findAll();
    }
}
