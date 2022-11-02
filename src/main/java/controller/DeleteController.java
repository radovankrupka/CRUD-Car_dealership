package controller;


import DAO.BrandDAO;

import DAO.CarDAO;
import model.Brand;
import model.Car;
import model.CarBrand;


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

        int ID = 0;
        String type = request.getParameter("type");
        if (request.getParameter("ID") != null ) ID = Integer.parseInt(request.getParameter("ID"));

        switch (type) {

            //DELETE CAR
            case "car": {

                CarDAO.deleteCar(ID);
                response.sendRedirect("cars");

                break;
            }

            //UPDATE BRAND
            case "brand": {

                BrandDAO.deleteBrand(ID);
                response.sendRedirect("brands");
                break;
            }


            default:

        }



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
