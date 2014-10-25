/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.model;

import java.util.List;
import uuu.domain.UMallException;

/**
 *
 * @author Administrator
 */
public interface DAOInterface<K, T> {
    public void insert(T data) throws UMallException;
    public void update(T data) throws UMallException;
    public void delete(T data) throws UMallException;
    
    public T get(K id)throws UMallException;
    public List<T> getAll()throws UMallException;
    
    
}
