package controller;


import DAO.CarDAO;
import model.Car;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int carID = Integer.parseInt(request.getParameter("carID"));

        CarDAO.deleteCar(carID);

        response.sendRedirect("cars");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
