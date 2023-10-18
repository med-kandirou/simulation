package Interfaces;

import DTO.Client;
import DTO.Employe;

import java.util.ArrayList;
import java.util.Optional;

public interface IEmploye extends IData<Employe,String>{
    ArrayList<Employe> getAll();
    Optional<Employe> getEmployebyId(String matricule);
}
