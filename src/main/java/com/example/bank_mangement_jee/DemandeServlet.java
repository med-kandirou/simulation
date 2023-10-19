package com.example.bank_mangement_jee;

import DAO.ImpDemandeCredit;
import DAO.ImpEmploye;
import Services.DemandeService;
import Services.EmployeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name ="DemandeServlet", urlPatterns = {"/demande-create","/demande-display","/demande-search"})
public class DemandeServlet extends HttpServlet {

    DemandeService service;

    @Override
    public void init() throws ServletException {
        service= new DemandeService(new ImpDemandeCredit());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }



}
