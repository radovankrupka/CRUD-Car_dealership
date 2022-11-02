package DAO;

import model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
                customer.setCustomer_id(rs.getInt("id"));
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setAddress(rs.getString("address"));
                customerList.add(customer);
            }

            con.close();

        }catch(Exception e){e.printStackTrace();}

        return customerList;
    }
}
