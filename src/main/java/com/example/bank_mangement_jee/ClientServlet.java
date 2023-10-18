package com.example.bank_mangement_jee;

import DAO.ImpClient;
import DTO.Client;
import Services.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@WebServlet(name ="CLientServlet", urlPatterns = {"/client-create", "/client-update","/client-display","/client-search","/client-delete"})
public class ClientServlet extends HttpServlet {
    String code;
    String fname;
    String lname;
    String bday;
    String tele;
    String adresse;
    DateTimeFormatter formatter=null;
    Client cl;
    String requestURL;
    ClientService service;
    @Override
    public void init() throws ServletException {
        service= new ClientService(new ImpClient());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.requestURL=request.getServletPath();
        switch (this.requestURL){
            case "/client-display" :
                request.setAttribute("clients",service.getAll());
                request.getRequestDispatcher("/ClientPages/display.jsp").forward(request, response);
                break;
            case "/client-create" :
                request.getRequestDispatcher("/ClientPages/create.jsp").forward(request, response);
                break;
            case "/client-update" :
                String code = request.getParameter("code");
                request.setAttribute("client",service.getClientbyId(code));
                request.getRequestDispatcher("/ClientPages/update.jsp").forward(request, response);
                break;
            case "/client-search" :
                String param = request.getParameter("param");
                request.setAttribute("clients",service.search(param));
                request.getRequestDispatcher("/ClientPages/display.jsp").forward(request, response);
                break;
            case "/client-delete" :
                service.delete(request.getParameter("id"));
                request.setAttribute("clients",service.getAll());
                request.getRequestDispatcher("/ClientPages/display.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (this.requestURL){
            case "/client-create" :
                code = req.getParameter("code");
                fname = req.getParameter("fname");
                lname = req.getParameter("lname");
                bday = req.getParameter("bday");
                tele = req.getParameter("tele");
                adresse = req.getParameter("adresse");
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                cl= new Client(code,fname,lname,LocalDate.parse(bday, formatter),tele,adresse);
                boolean added=this.service.add(cl);
                if(added){
                    req.getRequestDispatcher("/ClientPages/create.jsp").forward(req, resp);
                }
                break;
            case "/client-update":
                code = req.getParameter("code");
                fname = req.getParameter("fname");
                lname = req.getParameter("lname");
                bday = req.getParameter("bday");
                tele = req.getParameter("phone");
                adresse = req.getParameter("adresse");
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                cl= new Client(code,fname,lname,LocalDate.parse(bday, formatter),tele,adresse);
                boolean updated=this.service.update(cl);
                if(updated){
                    Optional<Client> client=Optional.ofNullable(cl);
                    req.setAttribute("client",client);
                    req.getRequestDispatcher("/ClientPages/update.jsp").forward(req, resp);
                }
            default:
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}