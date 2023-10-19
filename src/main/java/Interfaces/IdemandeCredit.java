package Interfaces;

import DTO.DemandeCredit;

import java.time.LocalDate;
import java.util.List;

public interface IdemandeCredit extends IData<DemandeCredit,Integer>{
    List<DemandeCredit> getbydate(LocalDate date);
    List<DemandeCredit> getbyetat(String etat);
    List<DemandeCredit> gatAll();
}
