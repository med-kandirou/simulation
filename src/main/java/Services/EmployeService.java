package Services;

import DAO.ImpClient;
import DAO.ImpEmploye;
import DTO.Client;
import DTO.Employe;

import java.util.ArrayList;
import java.util.Optional;

public class EmployeService {
    ImpEmploye impEmploye;
    public EmployeService(ImpEmploye impEmploye){
        this.impEmploye=impEmploye;
    }

    public boolean add(Employe employe){
        Optional<Employe> optEmploye= impEmploye.add(employe);
        return optEmploye.isPresent();
    }

    public boolean update(Employe employe){
        Optional<Employe> optEmploye= impEmploye.update(employe);
        return optEmploye.isPresent();
    }

    public ArrayList getAll(){
        ArrayList<Employe> optEmploye= impEmploye.getAll();
        return optEmploye;
    }

    public Optional<Employe> getemployebyId(String matricule){
        Optional<Employe> employe= impEmploye.getEmployebyId(matricule);
        return employe;
    }

    public ArrayList search(String param){
        ArrayList<Employe> employes= impEmploye.search(param);
        return employes;
    }

    public boolean delete(String id){
        return impEmploye.delete(id);
    }
}
