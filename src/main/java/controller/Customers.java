package controller;


import DAO.BrandDAO;
import DAO.CarDAO;

import DAO.CustomerDAO;
import model.Brand;
import model.Car;
import model.CarBrand;
import model.Customer;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customers")
public class Customers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer> customerList = new ArrayList<>();
        customerList.addAll(CustomerDAO.getAllCustomers());

        request.getSession().setAttribute("customerList",customerList);
        response.sendRedirect("customer-list.jsp");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
