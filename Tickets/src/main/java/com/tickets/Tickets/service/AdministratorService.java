package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.Administrator;

public interface AdministratorService {
    public Administrator find(String name,String password);
}
