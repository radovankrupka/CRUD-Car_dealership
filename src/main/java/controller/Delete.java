package controller;


import DAO.BrandDAO;

import DAO.CarDAO;
import model.Car;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delete")
public class Delete extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int ID = 0;
        String type = request.getParameter("type");
        if (request.getParameter("ID") != null ) ID = Integer.parseInt(request.getParameter("ID"));

        switch (type) {

            //DELETE CAR
            case "car": {

                if (!(CarDAO.isInLinkingTable(ID))) {
                    CarDAO.deleteCar(ID);
                    response.sendRedirect("cars");
                    request.getSession().setAttribute("deletionError", "");

                }
                else {
                    System.out.println("cannot delete");
                    request.getSession().setAttribute("deletionError", "Could not delete car, because it exists in linking table");
                    response.sendRedirect("car-list.jsp");

                }
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
