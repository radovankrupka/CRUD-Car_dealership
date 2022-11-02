package controller;


import DAO.BrandDAO;

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
        String type = request.getParameter("type");
        if (request.getParameter("ID") != null ) ID = Integer.parseInt(request.getParameter("ID"));  //ID pre car aj brand objekt

        switch (type) {

            //UPDATE OR CREATE CAR
            case "car": {

               /* List<Brand> brands = new ArrayList<>();
                brands.addAll(BrandDAO.getAllBrands());
                request.getSession().setAttribute("brands", brands);
                if (ID != 0) {
                    CarBrand carBrand = (CarBrandDAO.getCarBrandById(ID));
                    request.getSession().setAttribute("carBrand", carBrand);
                }
                response.sendRedirect("car-add.jsp");
                break;*/
            }

            //UPDATE BRAND
            case "brand": {

                Brand brand = new Brand();
                if (ID != 0) {
                    brand = BrandDAO.getBrandById(ID);
                    request.getSession().setAttribute("brand", brand);
                }
                response.sendRedirect("brand-add.jsp");
                break;
            }

            default:{response.sendRedirect("cars");}
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
