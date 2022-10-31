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
            con= DriverManager.getConnection("jdbc:mysql://localhost/car-dealership","root","");
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
                car.setCar_id(rs.getInt("id"));
                car.setBrand_id(rs.getInt("brands_id"));
                car.setPlate_num(rs.getString("plate_num"));
                car.setYear_of_manufacture(rs.getInt("YOM"));
                car.setMileage(rs.getInt("mileage"));
                car.setPrice(rs.getInt("price"));
                car.setCrashed(rs.getBoolean("crashed"));
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
            stmt.executeUpdate ("DELETE FROM cars WHERE cars.car_id = "+ carID );
            con.close();

        }catch(Exception e){e.printStackTrace();}

    }

}
