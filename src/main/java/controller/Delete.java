package controller;


import DAO.BrandDAO;

import DAO.CarDAO;
import DAO.CarOwnerDAO;
import DAO.CustomerDAO;
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
                    request.getSession().setAttribute("carError", "");

                }
                else {
                    System.out.println("cannot delete");
                    request.getSession().setAttribute("carError", "Could not delete car, because it exists in linking table");
                    response.sendRedirect("cars");

                }
                break;
            }

            //DELETE CUSTOMER
            case "customer": {
                //ADD CONTROL FOR DELETING CUSTOMERS EXISTING IN LINKING TABLE
                if (!(CustomerDAO.isInLinkingTable(ID))) {
                    CustomerDAO.deleteCustomer(ID);
                    request.getSession().setAttribute("customerError", "");
                    response.sendRedirect("customers");

                }
                else {
                    System.out.println("cannot delete");
                    request.getSession().setAttribute("customerError", "Could not delete customer, because it exists in linking table");
                    response.sendRedirect("customers");
                }

                break;
            }
            case "carOwner": {

                CarOwnerDAO.deleteCarOwner(ID);
                response.sendRedirect("home");

                break;
            }


            default:

        }



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
