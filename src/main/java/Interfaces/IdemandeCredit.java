package Interfaces;

import DTO.DemandeCredit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import DTO.Historique;
import Enum.EtatCredit;

public interface IdemandeCredit extends IData<DemandeCredit,Integer>{
    List<DemandeCredit> getbydate(LocalDate date);
    List<DemandeCredit> getbyetat(String etat);
    List<DemandeCredit> gatAll();
    Optional<DemandeCredit> updateStatus(int demandeNum, String newStatus);

    List<Historique> getHistorique(int numDemande);
}
