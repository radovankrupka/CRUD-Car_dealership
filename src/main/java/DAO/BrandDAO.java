package DAO;

import model.Brand;
import model.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {


    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/car-dealership","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static List<Brand> getAllBrands(){
        List<Brand> brandList=new ArrayList<>();

        try{
            Connection con = BrandDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from brands");

            while(rs.next()){
                Brand brand = new Brand();
                brand.setBrand_id(rs.getInt("brand_id"));
                brand.setBrand_name(rs.getString("brand"));
                brand.setModel(rs.getString("model"));
                brandList.add(brand);

            }

            con.close();

        }catch(Exception e){e.printStackTrace();}

        return brandList;
    }

    
}
