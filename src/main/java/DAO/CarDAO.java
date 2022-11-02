package DAO;

import model.Car;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/car_dealership","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    //save , update, delete, getbyID



    public static List<Car> getAllCars(){
        List<Car> carList=new ArrayList<>();

        try{
            Connection con = CarDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from cars");

            while(rs.next()){
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));
                car.setPlate_num(rs.getString("plate_num"));
                car.setYear_of_manufacture(rs.getInt("year_of_manufacture"));
                car.setMileage(rs.getInt("mileage"));
                car.setPrice(rs.getInt("price"));
                carList.add(car);

            }

            con.close();

        }catch(Exception e){e.printStackTrace();}

        return carList;
    }

    public static void deleteCar(int carID){

        try{
            Connection con = CarDAO.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate ("DELETE FROM cars WHERE cars.id = "+ carID );
            con.close();

        }catch(Exception e){e.printStackTrace();}

    }

    public static void saveNewCar(HttpServletRequest request){


        try{
            Connection con = CarDAO.getConnection();

            String sql = "INSERT INTO cars (brand,plate_num,year_of_manufacture,mileage,price) values (?,?,?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString (1, request.getParameter("brand"));
            preparedStmt.setString (2, request.getParameter("plate_num"));
            preparedStmt.setInt (3,Integer.parseInt(request.getParameter("year_of_manufacture")));
            preparedStmt.setInt (4, Integer.parseInt(request.getParameter("mileage")));
            preparedStmt.setInt (5,Integer.parseInt(request.getParameter("price")));

            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}
    }

    public static void updateCar(HttpServletRequest request){
        try{
            Connection con = CarDAO.getConnection();

            String sql = "UPDATE cars SET plate_num = ?,mileage = ?,year_of_manufacture = ?,price = ?, brand = ? WHERE id =" + request.getParameter("id");

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString (1, request.getParameter("plate_num"));
            preparedStmt.setInt (2, Integer.parseInt(request.getParameter("mileage")));
            preparedStmt.setInt (3,Integer.parseInt(request.getParameter("year_of_manufacture")));
            preparedStmt.setInt (4,Integer.parseInt(request.getParameter("price")));
            preparedStmt.setString (5, request.getParameter("brand"));

            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}


    }


    public static Car getCarById(int id) {
        Car car = new Car();

        try{
            Connection con = CarDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from cars WHERE id = "+id);

            while(rs.next()){
                car.setId(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));
                car.setPlate_num(rs.getString("plate_num"));
                car.setYear_of_manufacture(rs.getInt("year_of_manufacture"));
                car.setMileage(rs.getInt("mileage"));
                car.setPrice(rs.getInt("price"));
            }

            con.close();

        }catch(Exception e){e.printStackTrace();}


        return car;
    }

    public static boolean isInLinkingTable(int id) {
        boolean flag = false;
        try{
            Connection con = CarDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select COUNT(*) as pocet from customers_cars WHERE cars_id = "+id);
            
            rs.next();
            if (rs.getInt("pocet") == 0) flag = false;
            else flag = true;

            con.close();

        }catch(Exception e){e.printStackTrace();}
        return flag;
    }
}
