package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.Administrator;
import com.tickets.Tickets.mapper.AdministratorMapper;
import com.tickets.Tickets.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Transactional(readOnly = true)
    @Override
    public Administrator find(String name, String password) {
        Administrator ad =administratorMapper.find(name,password);
        return ad;
    }
}
