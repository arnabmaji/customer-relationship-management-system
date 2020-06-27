package io.github.arnabmaji19.crmsystem.dao;

import io.github.arnabmaji19.crmsystem.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        /*
         * Retrieve all customers from database
         */

        var session = sessionFactory.getCurrentSession();
        var query = session.createQuery("from Customer", Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        /*
         * Save or update customer in the database
         */

        var session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        /*
         * Get customer based on the id from database
         */

        var session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        /*
         * Delete customer for the given id from database
         */

        var session = sessionFactory.getCurrentSession();
        var query = session.createQuery("delete from Customer where id = :customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }
}
