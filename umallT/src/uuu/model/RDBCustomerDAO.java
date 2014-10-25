/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import uuu.domain.BloodType;
import uuu.domain.Customer;
import uuu.domain.UMallException;

/**
 *
 * @author Administrator
 */
public class RDBCustomerDAO implements DAOInterface<String, Customer> {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/umall?useUnicode=true&characterEncoding=utf-8";
    private static final String UID = "root";
    private static final String PWD = "123456";

    public Connection getConnection() throws UMallException {
        DataSource ds = null;
        Connection connection = null;
        Context ctx;
        try {
            ctx = new InitialContext();
            if (ctx == null) {
                throw new RuntimeException("JNDI Context could not be found.");
            }
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/umall");
            if (ds == null) {
                throw new RuntimeException("DataSource could not be found.");
            }
            connection = ds.getConnection();
            System.out.print("取得Connection Pool:" + connection);
        } catch (Exception ex) {
            ex.printStackTrace();
            //            throw new UMallException(ex);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, UID, PWD);
            } catch (Exception e) {
                throw new UMallException("無法建立資料庫連線!", e);
            }
        }
        System.out.println(connection);
        return connection;
    }
    private static final String INSERT_SQL = "INSERT INTO customers "
            + "(id, name, password, phone, gender, address, email, married, birth_date, blood_type) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_SQL = "UPDATE customers SET "
            + "name=?, password=?, phone=?, gender=? , address=?, email=?, married=?, birth_date=?, blood_type=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM customers WHERE id=?";
    private static final String SELECT_ALL = "SELECT id, name, password, phone, gender, address, email, married, birth_date, blood_type FROM customers";
    private static final String SELECT_SQL = SELECT_ALL + " WHERE id=?";

    @Override
    public void insert(Customer o) throws UMallException {
        //Class.forName(DRIVER);
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_SQL)) {
            pstmt.setString(1, o.getId());
            pstmt.setString(2, o.getName());
            pstmt.setString(3, o.getPassword());
            pstmt.setString(4, o.getPhone());
            pstmt.setString(5, String.valueOf(o.getGender()));
            pstmt.setString(6, o.getAddress());
            pstmt.setString(7, o.getEmail());
            pstmt.setBoolean(8, o.isMarried());
            pstmt.setDate(9, new java.sql.Date(o.getBirthDate().getTime()));
            pstmt.setString(10, o.getBloodtype().name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new UMallException("新增客戶資料失敗：" + o, e);
        }
    }

    @Override
    public void update(Customer o) throws UMallException {
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_SQL)) {
            pstmt.setString(1, o.getName());
            pstmt.setString(2, o.getPassword());
            pstmt.setString(3, o.getPhone());
            pstmt.setString(4, String.valueOf(o.getGender()));
            pstmt.setString(5, o.getAddress());
            pstmt.setString(6, o.getEmail());
            pstmt.setBoolean(7, o.isMarried());
            pstmt.setDate(8, new java.sql.Date(o.getBirthDate().getTime()));
            pstmt.setString(9, o.getBloodtype().name());
            pstmt.setString(10, o.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new UMallException("修改客戶資料失敗：" + o, e);
        }
    }

    @Override
    public void delete(Customer o) throws UMallException {
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_SQL)) {
            pstmt.setString(1, o.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new UMallException("刪除客戶資料失敗：" + o, e);
        }
    }

    @Override
    public Customer get(String key) throws UMallException {
      Customer c = null;
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(SELECT_SQL)) {
            pstmt.setString(1, key);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    if (rs.getRow() > 1) {
                        throw new UMallException("讀取客戶資料失敗, id:" + key);
                    }
                    c = new Customer();
                    c.setId(rs.getString("id"));
                    c.setName(rs.getString("name"));
                    c.setPassword(rs.getString("password"));
                    c.setPhone(rs.getString("phone"));
                    c.setGender(rs.getString("gender").charAt(0));
                    c.setAddress(rs.getString("address"));
                    if (rs.getString("email") != null) {
                        c.setEmail(rs.getString("email"));
                    }
                    c.setMarried(rs.getBoolean("married"));
                    c.setBirthDate(rs.getDate("birth_date"));
                    c.setBloodtype(BloodType.valueOf(rs
                            .getString("blood_type")));
                    System.out.println("get Customer:" + c);
                }
            } catch (SQLException e) {
                throw new UMallException("讀取客戶資料失敗, id:" + key, e);
            }
        } catch (SQLException e) {
            throw new UMallException("查詢客戶資料失敗, id:" + key, e);
        }
        return c;
    }

    @Override
    public List<Customer> getAll() throws UMallException {
        List<Customer> list = new ArrayList<>();
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setPassword(rs.getString("password"));
                c.setPhone(rs.getString("phone"));
                c.setGender(rs.getString("gender").charAt(0));
                c.setAddress(rs.getString("address"));
                if (rs.getString("email") != null) {
                    c.setEmail(rs.getString("email"));
                }
                c.setMarried(rs.getBoolean("married"));
                c.setBirthDate(rs.getDate("birth_date"));
                c.setBloodtype(BloodType.valueOf(rs.getString("blood_type")));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new UMallException("查詢全部客戶資料失敗！", e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        try {
            RDBCustomerDAO dao = new RDBCustomerDAO();
            System.out.println(dao.getAll());
        } catch (UMallException ex) {
            Logger.getLogger(RDBCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
