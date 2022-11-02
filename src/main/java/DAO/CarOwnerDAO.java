package DAO;

import model.Car;
import model.CarOwner;
import model.Customer;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.time.LocalDate;
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

                customer.setId(rs.getInt("customers.id"));
                customer.setFirst_name(rs.getString("customers.first_name"));
                customer.setLast_name(rs.getString("customers.last_name"));
                customer.setAddress(rs.getString("customers.address"));

                carOwner.setId(Integer.parseInt(rs.getString("customers_cars.id")));
                carOwner.setPurchase_date(rs.getString("customers_cars.purchase_date"));
                carOwner.setReturn_date(rs.getString("customers_cars.return_date"));

                car.setId(rs.getInt("cars.id"));
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

    public static void addNewCarOwner(HttpServletRequest request) {
        try{
            Connection con = CarOwnerDAO.getConnection();

            String sql = "INSERT INTO customers_cars (customers_id,cars_id,purchase_date,return_date) values (?,?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setInt(1, Integer.parseInt(request.getParameter("customers_id")));
            preparedStmt.setInt(2, Integer.parseInt(request.getParameter("cars_id")));
            preparedStmt.setDate(3,Date.valueOf(request.getParameter("purchase_date")));
            if (request.getParameter("return_date").equals("")) {
                preparedStmt.setNull(4, Types.DATE);
            } else {
                preparedStmt.setDate(4,Date.valueOf(request.getParameter("return_date")));
            }


            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}


    }

    public static CarOwner getCarOwnerById(int id) {
        CarOwner carOwner = new CarOwner();

        try{
            Connection con = CarOwnerDAO.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from customers_cars WHERE id = "+id);

                rs.next();
                carOwner.setId(rs.getInt("id"));
                carOwner.setCustomer(CustomerDAO.getCustomerById(rs.getInt("customers_id")));
                carOwner.setCar(CarDAO.getCarById(rs.getInt("cars_id")));
                carOwner.setPurchase_date(rs.getString("purchase_date"));
                carOwner.setReturn_date(rs.getString("return_date"));
            con.close();

        }catch(Exception e){e.printStackTrace();}


        return carOwner;


    }

    public static void updateCarOwner(HttpServletRequest request) {

        try{
            Connection con = CarOwnerDAO.getConnection();

            String sql = "UPDATE customers_cars SET customers_id = ?, cars_id=?, purchase_date=?, return_date=? WHERE id =" + request.getParameter("id");

            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setInt(1, Integer.parseInt(request.getParameter("customers_id")));
            preparedStmt.setInt(2, Integer.parseInt(request.getParameter("cars_id")));
            preparedStmt.setDate(3, Date.valueOf(request.getParameter("purchase_date")));
            if (request.getParameter("return_date").equals("")) {
                preparedStmt.setNull(4, Types.DATE);
            } else {
                preparedStmt.setDate(4,Date.valueOf(request.getParameter("return_date")));
            }

            preparedStmt.executeUpdate();

            con.close();

        }catch(Exception e){e.printStackTrace();}

    }

    public static void deleteCarOwner(int id) {
        try{
            Connection con = CarOwnerDAO.getConnection();
            Statement stmt = con.createStatement();

            stmt.executeUpdate ("DELETE FROM customers_cars WHERE id = "+ id );
            con.close();

        }catch(Exception e){e.printStackTrace();}
    }
}
