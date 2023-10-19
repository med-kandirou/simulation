package Services;

import DAO.ImpDemandeCredit;
import DTO.Client;
import DTO.DemandeCredit;

import java.util.Optional;

public class DemandeService {

    private ImpDemandeCredit impdemande;

    public DemandeService(ImpDemandeCredit demandeCredit){
        this.impdemande=demandeCredit;
    }

    public Optional<DemandeCredit> add(DemandeCredit demande){
        return impdemande.add(demande);
    }
}
