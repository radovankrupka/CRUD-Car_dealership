package controller;


import DAO.CarDAO;
import model.Car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MainController")
public class HomeController extends HttpServlet {

    private List<Car> carList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //nacitat data z db

        carList.addAll(CarDAO.getAllCars());
        //request.setAttribute("obj", Obj);
        for (Car car:carList) {

            System.out.println(car.getBrand());

        }
        request.getSession().setAttribute("carList", carList);

        response.sendRedirect("home-page.jsp");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
