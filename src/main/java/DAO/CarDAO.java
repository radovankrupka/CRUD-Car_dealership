package DAO;

import model.Car;

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
                car.setId(rs.getInt(1));
                car.setBrand(rs.getString(2));
                car.setPlate_num(rs.getString(3));
                car.setYear_of_manufacture(rs.getInt(4));
                car.setMileage(rs.getInt(5));
                car.setPrice(rs.getInt(6));
                carList.add(car);

            }

            con.close();

        }catch(Exception e){e.printStackTrace();}

        return carList;
    }

}
