package controller;


import DAO.BrandDAO;

import DAO.CarDAO;
import DAO.CarOwnerDAO;
import DAO.CustomerDAO;
import model.Brand;
import model.Car;
import model.CarOwner;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update")
public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = 0;
        request.getSession().setAttribute("carError", "");
        request.getSession().setAttribute("customerError", "");

        String type = request.getParameter("type");
        if (!(request.getParameter("ID").equals("") )) ID = Integer.parseInt(request.getParameter("ID"));  //ID pre car aj brand objekt

        switch (type) {

            //UPDATE OR CREATE CAR
            case "carUpdate": {

                if (ID != 0) {
                    Car car = (CarDAO.getCarById(ID));
                    request.getSession().setAttribute("car", car);
                }
                response.sendRedirect("car-add.jsp");
                break;
            }
            case "carAdd": {

                request.getSession().removeAttribute("car");
                response.sendRedirect("car-add.jsp");
                break;
            }
            //UPDATE OR ADD CUSTOMER
            case "customerAdd": {
                request.getSession().removeAttribute("customer");
                response.sendRedirect("customer-add.jsp");
                break;
            }
            case "customerUpdate": {

                Customer customer = new Customer();
                if (ID != 0) {
                    customer = CustomerDAO.getCustomerById(ID);
                    request.getSession().setAttribute("customer", customer);
                }
                response.sendRedirect("customer-add.jsp");
                break;
            }
            case "carOwnerAdd": {

                List<Customer> customerList = new ArrayList<>();
                List<Car> carList = new ArrayList<>();

                customerList.addAll(CustomerDAO.getAllCustomers());
                carList.addAll(CarDAO.getAllCars());

                request.getSession().setAttribute("carList", carList);
                request.getSession().setAttribute("customerList", customerList);

                request.getSession().removeAttribute("carOwner");
                response.sendRedirect("carowner-add.jsp");
                break;
            }

            case "carOwnerUpdate": {
                List<Customer> customerList = new ArrayList<>();
                List<Car> carList = new ArrayList<>();

                customerList.addAll(CustomerDAO.getAllCustomers());
                carList.addAll(CarDAO.getAllCars());

                CarOwner carOwner = new CarOwner();
                carOwner = CarOwnerDAO.getCarOwnerById(ID);

                request.getSession().setAttribute("carList", carList);
                request.getSession().setAttribute("customerList", customerList);
                request.getSession().setAttribute("carOwner",carOwner);
                System.out.println(" ID : " + ID);
                System.out.println(carOwner.getId() + " " + carOwner.getCustomer().getFirst_name() + " " + carOwner.getCar().getBrand());
                response.sendRedirect("carowner-add.jsp");
                break;
            }

            default:{response.sendRedirect("home");}
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
