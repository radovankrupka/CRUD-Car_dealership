package DAO;

import model.Brand;
import model.Brand;

import javax.servlet.http.HttpServletRequest;
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


    public static void deleteBrand(int id) {
        try{
            Connection con = BrandDAO.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate ("DELETE FROM cars WHERE cars.brands_id = "+ id );
            stmt.executeUpdate ("DELETE FROM brands WHERE brands.brand_id = "+ id );
            con.close();

        }catch(Exception e){e.printStackTrace();}


    }

    public static void updateBrand(HttpServletRequest request) {

        try{
            Connection con = BrandDAO.getConnection();

            String sql = "UPDATE brands SET brand = ?, model = ? WHERE brand_id =" + request.getParameter("brand_id");

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString (1, request.getParameter("brand_name"));
            preparedStmt.setString (2, request.getParameter("model"));

            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}
    }

    public static void saveNewBrand(HttpServletRequest request) {

        try{
            Connection con = BrandDAO.getConnection();

            String sql = "INSERT INTO brands SET (brand,model) VALUES (?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString (1, request.getParameter("brand_name"));
            preparedStmt.setString (2, request.getParameter("model"));

            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}

    }

    public static Brand getBrandById(int ID){

        Brand brand = new Brand();

        try{
            Connection con = BrandDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from brands WHERE brand_id=" + ID);


            brand.setBrand_id(rs.getInt("brand_id"));
            brand.setBrand_name(rs.getString("brand"));
            brand.setModel(rs.getString("model"));

            con.close();

        }catch(Exception e){e.printStackTrace();}

        return brand;
    }

}
