/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.model;
import java.util.List;
import uuu.domain.Customer;
import uuu.domain.UMallException;


public class CustomerService {
    private DAOInterface<String, Customer>dao = new RDBCustomerDAO();
    
    public void createCustomer(Customer customer) throws UMallException{
          dao.insert(customer);
    }
    
    public void register(Customer customer) throws UMallException{
        this.createCustomer(customer);
    }    

    public void updateCustomer(Customer customer) throws UMallException{
        dao.update(customer);
    }

    public void deleteCustomer(Customer customer) throws UMallException{
        dao.delete(customer);
    }
    
    public Customer getCustomer(String id) throws UMallException{
        return dao.get(id);
    }
    
    public List<Customer> getAllCustomers() throws UMallException{
        return dao.getAll();
    }
    
    public Customer login(String id, String password)throws UMallException{
        Customer c = this.getCustomer(id);
        if(c!=null && c.getPassword()!=null){
            if(c.getPassword().equals(password)){
                return c;
            }
        }
        return null;
    }    
}
