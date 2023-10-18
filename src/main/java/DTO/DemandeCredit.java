package DTO;
import jakarta.persistence.*;
import lombok.*;
import Enum.EtatCredit;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@Table(name = "demandecredit")
public class DemandeCredit {

     @Id
     private int numero;
     private EtatCredit etat;
     private Simulation simulation;
     @NonNull private String remarques;
     private LocalDate date;
     private Client client;
}
