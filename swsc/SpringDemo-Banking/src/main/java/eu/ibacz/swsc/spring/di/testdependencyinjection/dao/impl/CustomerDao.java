/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ibacz.swsc.spring.di.testdependencyinjection.dao.impl;

import eu.ibacz.swsc.spring.di.testdependencyinjection.dto.Customer;
import java.util.List;

/**
 *
 * @author xkaiser1
 */
public interface CustomerDao {
    public List<Customer> findAll();
    public void save(Customer customer);
}
