package com.example.bank_mangement_jee;

import DAO.ImpClient;
import DAO.ImpEmploye;
import DTO.Client;
import DTO.Employe;
import Services.ClientService;
import Services.EmployeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@WebServlet(urlPatterns = {"/employe-create", "/employe-update","/employe-display","/employe-search","/employe-delete"})
public class EmployeServlet extends HttpServlet {
    String mat;
    String fname;
    String lname;
    String bday;
    String tele;
    String adresseemail;
    String daterecrutement;
    DateTimeFormatter formatter=null;
    Employe emp;
    String requestURL;
    EmployeService service;
    @Override
    public void init() throws ServletException {
        service= new EmployeService(new ImpEmploye());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.requestURL=request.getServletPath();
        switch (this.requestURL){
            case "/employe-display" :
                request.setAttribute("employes",service.getAll());
                request.getRequestDispatcher("/EmployePages/display.jsp").forward(request, response);
                break;
            case "/employe-create" :
                request.getRequestDispatcher("/EmployePages/create.jsp").forward(request, response);
                break;
            case "/employe-update" :
                String mat = request.getParameter("mat");
                request.setAttribute("employe",service.getemployebyId(mat));
                request.getRequestDispatcher("/EmployePages/update.jsp").forward(request, response);
                break;
            case "/employe-search" :
                String param = request.getParameter("param");
                request.setAttribute("employes",service.search(param));
                request.getRequestDispatcher("/EmployePages/display.jsp").forward(request, response);
                break;
            case "/employe-delete" :
                service.delete(request.getParameter("id"));
                request.setAttribute("employes",service.getAll());
                request.getRequestDispatcher("/EmployePages/display.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (this.requestURL){
            case "/employe-create" :
                mat = req.getParameter("matricule");
                fname = req.getParameter("fname");
                lname = req.getParameter("lname");
                bday = req.getParameter("bday");
                tele = req.getParameter("tele");
                adresseemail = req.getParameter("adresseemail");
                daterecrutement=req.getParameter("drecrutement");
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                emp= new Employe(mat,fname,lname, LocalDate.parse(bday, formatter),tele,adresseemail,LocalDate.parse(daterecrutement, formatter));
                boolean added=this.service.add(emp);
                if(added){
                    req.getRequestDispatcher("/EmployePages/create.jsp").forward(req, resp);
                }
                break;
            case "/employe-update":
                mat = req.getParameter("matricule");
                fname = req.getParameter("fname");
                lname = req.getParameter("lname");
                bday = req.getParameter("bday");
                tele = req.getParameter("phone");
                adresseemail = req.getParameter("adresseemail");
                daterecrutement = req.getParameter("drecrutement");
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                emp = new Employe(mat,fname,lname,LocalDate.parse(bday, formatter),tele,adresseemail, LocalDate.parse(daterecrutement, formatter));
                boolean updated=this.service.update(emp);
                if(updated){
                    Optional<Employe> employe = Optional.ofNullable(emp);
                    req.setAttribute("employe",employe);
                    req.getRequestDispatcher("/EmployePages/update.jsp").forward(req, resp);
                }
            default:
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
