package uuu.model;

import java.util.List;
import uuu.domain.Customer;
import uuu.domain.Product;
import uuu.domain.UMallException;

public class ProductService {

    private DAOInterface<String, Product> dao = new ProtoProductDAO();

    public void createProduct(Product product) throws UMallException {
        dao.insert(product);
    }

    public void register(Product product) throws UMallException {
        this.createProduct(product);
    }

    public void updateProduct(Product product) throws UMallException {
        dao.update(product);
    }

    public void deleteProduct(Product product) throws UMallException {
        dao.delete(product);
    }

    public Product getProduct(String name) throws UMallException {
        return dao.get(name);
    }

    public List<Product> getAll() throws UMallException {
        return dao.getAll();
    }

    /*
    public Product login(Integer id, String password) throws UMallException {
        Customer c = this.getCustomer(id);
        if (c != null && c.getPassword() != null) {
            if (c.getPassword().equals(password)) {
                return c;
            }
        }
        return null;
    
    }
    */
}
