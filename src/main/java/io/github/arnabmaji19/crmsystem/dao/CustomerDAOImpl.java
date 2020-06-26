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
}
