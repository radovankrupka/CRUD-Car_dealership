package controller;


import DAO.BrandDAO;
import DAO.CarBrandDAO;
import model.Brand;
import model.CarBrand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update")
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = 0;

        String[] values = request.getParameterValues("type")[0].split("\\?");

        if (values[1] != null) ID = Integer.parseInt(values[1]);

        switch (values[0]) {

            //UPDATE CAR
            case "car": {
                List<Brand> brands = new ArrayList<>();
                brands.addAll(BrandDAO.getAllBrands());
                request.getSession().setAttribute("brands", brands);
                CarBrand carBrand = (CarBrandDAO.getCarBrandById(ID));
                request.getSession().setAttribute("carBrand", carBrand);
                response.sendRedirect("car-add.jsp");
                break;
            }

            //UPDATE BRAND
            case "brand": {


                break;
            }


            default:

        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
