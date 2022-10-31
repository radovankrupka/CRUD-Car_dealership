package controller;


import DAO.CarBrandDAO;
import DAO.CarDAO;
import DAO.CarOwnerDAO;
import model.Brand;
import model.Car;
import model.CarBrand;
import model.CarOwner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateCar")
public class UpdateCarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parameterValues = request.getParameterValues("type")[0];
        String[] values = parameterValues.split("\\?");

        switch (values[0]) {

            case "car": {
                System.out.println();

                break;
            }


            case "brand": {


                break;
            }


            default:

        }


        response.sendRedirect("car-list.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
