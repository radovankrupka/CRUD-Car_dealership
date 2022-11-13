package controller;



import DAO.CarOwnerDAO;

import model.CarOwner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      /* List<CarBrand> carBrandList = new ArrayList<>();
       carBrandList.addAll(CarBrandDAO.getCarsWithBrands());

       request.getSession().setAttribute("carBrandList", carBrandList);

       response.sendRedirect("home-list.jsp");*/

        List<CarOwner> carOwnerList = new ArrayList<>();
        carOwnerList.addAll(CarOwnerDAO.getCarOwners());

        request.getSession().setAttribute("carOwnerList", carOwnerList);
        request.getSession().setAttribute("carError", "");
        request.getSession().setAttribute("customerError", "");

        response.sendRedirect("home-page.jsp");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
