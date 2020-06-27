package io.github.arnabmaji19.crmsystem.dao;

import io.github.arnabmaji19.crmsystem.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
