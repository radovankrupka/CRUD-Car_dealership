package controller;


import DAO.BrandDAO;

import DAO.CarDAO;
import DAO.CarOwnerDAO;
import DAO.CustomerDAO;

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
        String type = request.getParameter("type");
        switch (type) {
            case "car": {      //AK IDE O AUTO
                if ( !( request.getParameter("id").equals("") ) ) { // AK IDE O EXISTUJUCE AUTO

                    System.out.println("existujuce auto");
                    CarDAO.updateCar(request);
                    response.sendRedirect("cars");

                } else {   // IDE O NOVE AUTO
                    System.out.println("nove auto");
                    CarDAO.saveNewCar(request);
                    response.sendRedirect("cars");

                }
                break;
            }
            case "customer": {          //AK IDE O CUSTOMER
                if (! (request.getParameter("id").equals("")) ) { //IDE O UPRAVU EXISTUJUCEHO CUSTOMER
                    System.out.println("uprava customer");
                    CustomerDAO.updateCustomer(request);
                    response.sendRedirect("customers");

                } else {
                    System.out.println("novy customer");
                    CustomerDAO.addNewCustomer(request);
                    response.sendRedirect("customers");

                }
                break;
            }
            case "carOwner": {
                if (! (request.getParameter("id").equals("")) ) { //IDE O UPRAVU EXISTUJUCEHO CAROWNER
                    System.out.println("uprava carowner");
                    CarOwnerDAO.updateCarOwner(request);
                    response.sendRedirect("home");

                } else {
                    System.out.println("novy carowner");
                    CarOwnerDAO.addNewCarOwner(request);
                    response.sendRedirect("home");
                }

                break;
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
