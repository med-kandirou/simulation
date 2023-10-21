package com.example.bank_mangement_jee;

import Config.LocalDateAdapter;
import DAO.ImpDemandeCredit;
import DAO.ImpEmploye;
import DTO.Client;
import DTO.DemandeCredit;
import DTO.Simulation;
import Services.DemandeService;
import Services.EmployeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name ="DemandeServlet", urlPatterns = {"/demande-create","/demande-display"})
public class DemandeServlet extends HttpServlet {
    DemandeService service;
    String requestURL;
    //demande
    private Simulation s;
    private String remarks;
    private Client client;
    //simulation
    private double taux;
    private double montant;
    private int duree;
    private double mensualite;

    @Override
    public void init() throws ServletException {
        //service= new DemandeService(new ImpDemandeCredit());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.requestURL=req.getServletPath();
        switch (this.requestURL){
            case "/demande-create":
                this.taux= Double.parseDouble(req.getParameter("taux"));
                this.montant= Double.parseDouble(req.getParameter("montant"));
                this.duree= Integer.parseInt(req.getParameter("dure"));
                this.remarks= req.getParameter("remarks");
                this.mensualite= Double.parseDouble(req.getParameter("mensualite"));
                this.client= new Client();
                s= new Simulation(montant,taux,duree,mensualite);
                client= new Client();
                client.setCode(req.getParameter("code"));
                DemandeCredit demandeCredit= new DemandeCredit(s.getTaux(),s.getMontant(),s.getMensualite(),s.getDure(),remarks,client);
                service.add(demandeCredit);
                break;
            default:
                break;
        }
    }



}
