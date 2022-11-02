package DAO;

import model.Car;
import model.CarOwner;
import model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarOwnerDAO {


    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/car_dealership","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static List<CarOwner> getCarOwners(){
        List<CarOwner> carOwnerList=new ArrayList<>();

        try{
            Connection con = CarOwnerDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car_dealership.cars INNER JOIN customers_cars ON cars.id = customers_cars.cars_id INNER JOIN customers ON customers_cars.customers_id = customers.id;");


            while(rs.next()){
                CarOwner carOwner = new CarOwner();
                Car car = new Car();
                Customer customer = new Customer();

                customer.setCustomer_id(rs.getInt("customers.id"));
                customer.setFirst_name(rs.getString("customers.first_name"));
                customer.setLast_name(rs.getString("customers.last_name"));
                customer.setAddress(rs.getString("customers.address"));

                carOwner.setPurchase_date(rs.getString("customers_cars.purchase_date"));
                carOwner.setReturn_date(rs.getString("customers_cars.return_date"));

                car.setCar_id(rs.getInt("cars.id"));
                car.setBrand(rs.getString("cars.brand"));
                car.setPlate_num(rs.getString("cars.plate_num"));
                car.setYear_of_manufacture(rs.getInt("cars.year_of_manufacture"));
                car.setMileage(rs.getInt("cars.mileage"));
                car.setPrice(rs.getInt("cars.price"));

                carOwner.setCar(car);
                carOwner.setCustomer(customer);

                carOwnerList.add(carOwner);

            }

            con.close();

        }catch(Exception e){e.printStackTrace();}

        return carOwnerList;
    }

}
