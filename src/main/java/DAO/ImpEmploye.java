package DAO;

import Config.Database;
import DTO.Client;
import DTO.Employe;
import Interfaces.IEmploye;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class ImpEmploye implements IEmploye {

    Connection cnx= Database.getconn();
    @Override
    public Optional<Employe> add(Employe employe) {
        try {
            String insertSql = "insert into employe (matricule, firstName, lastName, birthday, phone, adresseEmail,daterecrutement) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = cnx.prepareStatement(insertSql);
            preparedStatement.setString(1, employe.getMatricule());
            preparedStatement.setString(2, employe.getFirstName());
            preparedStatement.setString(3,employe.getLastName());
            preparedStatement.setDate(4, Date.valueOf(employe.getBirthday()));
            preparedStatement.setString(5,employe.getPhone());
            preparedStatement.setString(6,employe.getAdresseEmail());
            preparedStatement.setDate(7,Date.valueOf(employe.getDaterecrutement()));
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.ofNullable(employe);
            }
            preparedStatement.close();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employe> update(Employe employe) {
        try {
            String updateSql = "UPDATE employe SET firstName = ?, lastName = ?, birthday = ?, phone = ?, adresseEmail = ?, daterecrutement = ? WHERE matricule like ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(updateSql);
            preparedStatement.setString(1, employe.getFirstName());
            preparedStatement.setString(2,employe.getLastName());
            preparedStatement.setDate(3, Date.valueOf(employe.getBirthday()));
            preparedStatement.setString(4,employe.getPhone());
            preparedStatement.setString(5,employe.getAdresseEmail());
            preparedStatement.setDate(6,Date.valueOf(employe.getDaterecrutement()));
            preparedStatement.setString(7,employe.getMatricule());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                preparedStatement.close();
                return Optional.ofNullable(employe);
            }
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        try {
            String deleteSql = "DELETE FROM employe WHERE matricule like ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(deleteSql);
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return false;
    }

    public ArrayList<Employe> getAll() {
        ArrayList<Employe> employes= new ArrayList<>();
        try {
            String selectSql = "SELECT * FROM employe";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String matricule=resultSet.getString("matricule");
                String fname=resultSet.getString("firstName");
                String lname=resultSet.getString("lastName");
                String phone=resultSet.getString("phone");
                LocalDate date=resultSet.getDate("birthday").toLocalDate();
                String adresseemail=resultSet.getString("adresseEmail");
                LocalDate datederecrutement=resultSet.getDate("daterecrutement").toLocalDate();
                Employe employe=new Employe(matricule,fname,lname,date,phone,adresseemail,datederecrutement);
                employes.add(employe);
            }
            resultSet.close();
            preparedStatement.close();
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return employes;
    }

    @Override
    public Optional<Employe> getEmployebyId(String matricule) {
        Employe employe = null;
        try {
            String selectSql = "SELECT * FROM employe WHERE matricule like '"+matricule+"'";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String fname=resultSet.getString("firstName");
                String lname=resultSet.getString("lastName");
                String phone=resultSet.getString("phone");
                LocalDate date=resultSet.getDate("birthday").toLocalDate();
                String adresseemail=resultSet.getString("adresseEmail");
                LocalDate datederecrutement=resultSet.getDate("daterecrutement").toLocalDate();
                employe=new Employe(matricule,fname,lname,date,phone,adresseemail,datederecrutement);
            }
            resultSet.close();
            preparedStatement.close();
            return Optional.ofNullable(employe);
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return Optional.empty();
    }


    public ArrayList<Employe> search(String param) {
        ArrayList<Employe> employes= new ArrayList<>();
        try {
            String selectSql = "SELECT * FROM employe where matricule like ? or firstName like ? or lastName like ? or phone like ? or adresseEmail like ?";
            PreparedStatement preparedStatement = cnx.prepareStatement(selectSql);
            preparedStatement.setString(1, param);
            preparedStatement.setString(2,param);
            preparedStatement.setString(3,param);
            preparedStatement.setString(4,param);
            preparedStatement.setString(5,param);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String matricule=resultSet.getString("matricule");
                String fname=resultSet.getString("firstName");
                String lname=resultSet.getString("lastName");
                String phone=resultSet.getString("phone");
                LocalDate date=resultSet.getDate("birthday").toLocalDate();
                String adresseemail=resultSet.getString("adresseEmail");
                LocalDate datederecrutement=resultSet.getDate("daterecrutement").toLocalDate();
                employes.add(new Employe(matricule,fname,lname,date,phone,adresseemail,datederecrutement));
            }

            resultSet.close();
            preparedStatement.close();
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return employes;
    }
}
