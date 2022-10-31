package controller;


import DAO.CarDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("ECV") != null) {      //AK IDE O AUTO
            if (request.getParameter("car_id") != null ){ // AK IDE O EXISTUJUCE AUTO

                //vytvor novy objekt CarBrand (cize aj Car a Brand) na zaklade udajov v request.getParam
                //odosli ho do carbrandDAO pre update
            }
            else{   // IDE O NOVY CARBRAND OBJEKT

                //vytvor novy objekt CarBrand (cize aj Car a Brand) na zaklade udajov v request.getParam
                //odosli ho do carbrandDAO pre vytvorenie

            }
        }
        else {          //AK IDE O BRAND


            //rovnaky postup ako pri carbrand


        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
