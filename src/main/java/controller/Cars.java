package controller;


import DAO.CarDAO;

import model.Car;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cars")
public class Cars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<Car> carList = new ArrayList<>();
       carList.addAll(CarDAO.getAllCars());

       request.getSession().setAttribute("carList",carList);
        request.getSession().setAttribute("customerError", "");

        response.sendRedirect("car-list.jsp");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
