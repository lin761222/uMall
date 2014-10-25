/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.domain.Customer;
import uuu.domain.UMallException;

/**
 *
 * @author Administrator
 */
public class ProtoCustomerDAO implements DAOInterface<String, Customer> {

    private static final Map<String, Customer> customersMap = new HashMap<>();

    static {
        Customer c = new Customer("A123456789", "John", "台北市復興北路99號16F", "1234");
        try {
            c.setBirthDate(2000, 12, 25);
        } catch (UMallException ex) {
            
            Logger.getLogger(ProtoCustomerDAO.class.getName()).log(Level.SEVERE, "add customer to Map error", ex);
        }
        customersMap.put(c.getId(), c);

        c = new Customer("A223456781", "Mary", "台北市復興北路99號14F", "1234");
        try {
            c.setBirthDate(1996, 10, 1);
        } catch (UMallException ex) {
            Logger.getLogger(ProtoCustomerDAO.class.getName()).log(Level.SEVERE, "add customer to Map error", ex);
        }
        customersMap.put(c.getId(), c);
    }

    @Override
    public void insert(Customer data) throws UMallException {
        this.save(data);
    }

    @Override
    public void update(Customer data) throws UMallException {
        this.save(data);
    }

    private void save(Customer data) throws UMallException {
        if (data != null && data.getId() != null) {
            customersMap.put(data.getId(), data);
        } else {
            throw new UMallException("Customer can not be null, and must have valid id!");
        }
    }

    @Override
    public void delete(Customer data) throws UMallException {
        if (data != null && data.getId() != null) {
            customersMap.remove(data.getId());
        } else {
            throw new UMallException("Customer can not be null, and must have valid id!");
        }
    }

    @Override
    public Customer get(String id) throws UMallException {
        return customersMap.get(id);
    }

    @Override
    public List<Customer> getAll() throws UMallException {
        List<Customer> list = new ArrayList<Customer>();
        list.addAll(customersMap.values());

        return list;
    }

    public static void main(String[] args) {
        ProtoCustomerDAO dao = new ProtoCustomerDAO();
        try {
            System.out.println(dao.getAll());
            Customer c = dao.get("A223456709");
            if(c==null){
                c = new Customer("A223456709", "Anne", "Tainan", "5678");
                dao.insert(c);
            }
            c.setAddress("台北市復興北路99號3f");
            c.setBirthDate(2000, 12, 5);
            dao.update(c);
            System.out.println(dao.get("A223456709"));
            
            dao.delete(c);
            System.out.println(dao.get("A223456709"));
            
            System.out.println(dao.getAll());
        } catch (UMallException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
