package Services;

import DAO.ImpDemandeCredit;
import DTO.Client;
import DTO.DemandeCredit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DemandeService {

    private ImpDemandeCredit impdemande;

    public DemandeService(ImpDemandeCredit demandeCredit){
        this.impdemande=demandeCredit;
    }

    public Optional<DemandeCredit> add(DemandeCredit demande){
        return impdemande.add(demande);
    }

    public List<DemandeCredit> getbydate(LocalDate date){
        return impdemande.getbydate(date);
    }

    public List<DemandeCredit> getbyetat(String etat){
        return impdemande.getbyetat(etat);
    }

    public List<DemandeCredit> getAll(){
        return impdemande.gatAll();
    }
}
