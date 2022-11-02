package controller;



import DAO.CarOwnerDAO;

import model.CarOwner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      /* List<CarBrand> carBrandList = new ArrayList<>();
       carBrandList.addAll(CarBrandDAO.getCarsWithBrands());

       request.getSession().setAttribute("carBrandList", carBrandList);

       response.sendRedirect("home-list.jsp");*/

        List<CarOwner> carOwnerList = new ArrayList<>();
        carOwnerList.addAll(CarOwnerDAO.getCarOwners());

        request.getSession().setAttribute("carOwnerList", carOwnerList);
        response.sendRedirect("home-page.jsp");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
