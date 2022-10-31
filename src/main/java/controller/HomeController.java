package controller;


import DAO.CarBrandDAO;
import DAO.CarDAO;

import model.Brand;
import model.Car;
import model.CarBrand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cars")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<CarBrand> carBrandList = new ArrayList<>();
       carBrandList.addAll(CarBrandDAO.getCarsWithBrands());

       request.getSession().setAttribute("carBrandList", carBrandList);

       response.sendRedirect("car-list.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
