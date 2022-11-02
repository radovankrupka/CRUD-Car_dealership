package DAO;

import model.Customer;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/car_dealership","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static List<Customer> getAllCustomers(){
        List<Customer> customerList=new ArrayList<>();

        try{
            Connection con = CustomerDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from customers");

            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setAddress(rs.getString("address"));
                customerList.add(customer);
            }

            con.close();

        }catch(Exception e){e.printStackTrace();}

        return customerList;
    }

    public static Customer getCustomerById(int ID) {
        Customer customer = new Customer();

        try{
            Connection con = CustomerDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from customers WHERE id = " + ID);

            while(rs.next()){
                customer.setId(rs.getInt("id"));
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setAddress(rs.getString("address"));
            }

            con.close();
        }catch(Exception e){e.printStackTrace();}
    return customer;

    }

    public static void updateCustomer(HttpServletRequest request) {

        try{
            Connection con = CustomerDAO.getConnection();

            String sql = "UPDATE customers SET first_name = ?, last_name = ?, address = ? WHERE id =" + request.getParameter("id");

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString (1, request.getParameter("first_name"));
            preparedStmt.setString (2, request.getParameter("last_name"));
            preparedStmt.setString (3, request.getParameter("address"));
            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}
    }

    public static void addNewCustomer(HttpServletRequest request) {

        try{
            Connection con = CustomerDAO.getConnection();

            String sql = "INSERT INTO customers (first_name , last_name , address) VALUES (?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString (1, request.getParameter("first_name"));
            preparedStmt.setString (2, request.getParameter("last_name"));
            preparedStmt.setString (3, request.getParameter("address"));
            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}

    }

    public static void deleteCustomer(int id) {
        try{
            Connection con = CustomerDAO.getConnection();
            Statement stmt = con.createStatement();

            stmt.executeUpdate ("DELETE FROM customers WHERE id = "+ id );
            con.close();

        }catch(Exception e){e.printStackTrace();}

    }

    public static boolean isInLinkingTable(int id) {

        boolean flag = false;
        try{
            Connection con = CustomerDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select COUNT(*) as pocet from customers_cars WHERE customers_id = "+id);

            rs.next();
            if (rs.getInt("pocet") == 0) flag = false;
            else flag = true;

            con.close();

        }catch(Exception e){e.printStackTrace();}
        return flag;
    }
}
