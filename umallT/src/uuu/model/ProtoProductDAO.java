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
import uuu.domain.Product;
import uuu.domain.UMallException;

/**
 *
 * @author Administrator
 */
public class ProtoProductDAO implements DAOInterface<String, Product> {

    private static final Map<String, Product> productsMap = new HashMap<>();

    static {
        Product p = new Product(1, "HTC one", 16000, false, 10);
        productsMap.put(p.getName(), p);
        p = new Product(2, "IPhone 5S", 22000, false, 12);
        productsMap.put(p.getName(), p);
        p = new Product(3, "IPhone 4S", 12000, true, 2);
        productsMap.put(p.getName(), p);
        p = new Product(4, "HTC M8", 20000, false, 15);
        productsMap.put(p.getName(), p);
        p = new Product(5, "手機殼", 100, true, 50);
        productsMap.put(p.getName(), p);
    }

    private void save(Product data) throws UMallException {
        if (data != null) {
            productsMap.put(data.getName(), data);
        } else {
            throw new UMallException("產品不能為空, 請確認產品名稱!");
        }
    }

    @Override
    public void insert(Product data) throws UMallException {
        this.save(data);
    }

    @Override
    public void update(Product data) throws UMallException {
        this.save(data);
    }

    @Override
    public void delete(Product data) throws UMallException {
        if (data != null && data.getName() != null) {
            productsMap.remove(data.getName());
        } else {
            throw new UMallException("刪除失敗");
        }
    }

    @Override
    public Product get(String name) throws UMallException {
        return productsMap.get(name);
    }

    @Override
    public List<Product> getAll() throws UMallException {
        List<Product> list = new ArrayList<Product>();
        list.addAll(productsMap.values());
        return list;
    }

    
    public static void main(String args[]){
        ProtoProductDAO dao = new ProtoProductDAO();
        try {
            System.out.println(dao.getAll());
            Product p = dao.get("HTC one");
            Product p1 = new Product(1,"HTC one11111111111",18700);
            System.out.println("---------------");
            dao.insert(p1);
            System.out.println(dao.getAll());
            dao.delete(p1);
            System.out.println(dao.getAll());
            //System.out.println(dao.get(2));
        } catch (UMallException ex) {
            Logger.getLogger(ProtoProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
