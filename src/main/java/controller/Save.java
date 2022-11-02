package controller;


import DAO.BrandDAO;

import DAO.CarDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save")
public class Save extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("input  " + request.getParameter("plate_num"));

        if (!(request.getParameter("plate_num").equals(""))) {      //AK IDE O AUTO
            if (!(request.getParameter("id").equals(""))){ // AK IDE O EXISTUJUCE AUTO

                System.out.println("existujuce auto");
                CarDAO.updateCar(request);
                response.sendRedirect("cars");

            }
            else{   // IDE O NOVE AUTO

                CarDAO.saveNewCar(request);
                response.sendRedirect("cars");

            }
        }
        else {          //AK IDE O BRAND
            if (!(request.getParameter("brand_id")).equals("")){ //IDE O UPRAVU EXISTUJUCEHO BRAND

                BrandDAO.updateBrand(request);
                response.sendRedirect("brands");

            }
            else {      //IDE O BRAND NEW BRAND >:D

                BrandDAO.saveNewBrand(request);
                response.sendRedirect("brands");

            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
