package controller;


import DAO.BrandDAO;
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

@WebServlet("/brands")
public class BrandsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Brand> brandList = new ArrayList<>();
        brandList.addAll(BrandDAO.getAllBrands());

        request.getSession().setAttribute("brandList", brandList);

        response.sendRedirect("brand-list.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
