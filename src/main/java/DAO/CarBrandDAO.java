package DAO;

import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarBrandDAO {


    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/car-dealership","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static List<CarBrand> getCarsWithBrands() {
        List<CarBrand> carBrandList = new ArrayList<>();

        try {
            Connection con = CarBrandDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars INNER JOIN brands ON cars.brands_id = brands.brand_id;");


            while (rs.next()) {
                CarBrand carBrand = new CarBrand();
                Car car = new Car();
                Brand brand = new Brand();

                car.setCar_id(rs.getInt("car_id"));
                car.setBrand_id(rs.getInt("brands_id"));
                car.setPlate_num(rs.getString("plate_num"));
                car.setYear_of_manufacture(rs.getInt("YOM"));
                car.setMileage(rs.getInt("mileage"));
                car.setPrice(rs.getInt("price"));
                car.setCrashed(rs.getBoolean("crashed"));

                brand.setBrand_id(rs.getInt("brand_id"));
                brand.setBrand_name(rs.getString("brand"));
                brand.setModel(rs.getString("model"));

                carBrand.setCar(car);
                carBrand.setBrand(brand);

                carBrandList.add(carBrand);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return carBrandList;
    }

    public static CarBrand getCarBrandById(int ID) {
        CarBrand carBrand = new CarBrand();

        try {
            Connection con = CarBrandDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars INNER JOIN brands ON cars.brands_id = brands.brand_id WHERE cars.car_id = " + ID + ";" );


            while (rs.next()) {
                Car car = new Car();
                Brand brand = new Brand();

                car.setCar_id(rs.getInt("car_id"));
                car.setBrand_id(rs.getInt("brands_id"));
                car.setPlate_num(rs.getString("plate_num"));
                car.setYear_of_manufacture(rs.getInt("YOM"));
                car.setMileage(rs.getInt("mileage"));
                car.setPrice(rs.getInt("price"));
                car.setCrashed(rs.getBoolean("crashed"));

                brand.setBrand_id(rs.getInt("brand_id"));
                brand.setBrand_name(rs.getString("brand"));
                brand.setModel(rs.getString("model"));

                carBrand.setCar(car);
                carBrand.setBrand(brand);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return carBrand;
    }

    public static void updateCarBrand(CarBrand carBrand){

        //updatuj zaznamy vo oboch tabulkach

    }

    public static void addCarBrand(CarBrand carBrand){
        // pridaj nove zaznamy
    }

}


