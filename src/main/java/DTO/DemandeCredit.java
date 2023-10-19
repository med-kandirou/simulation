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
     private int number;
     @NonNull private EtatCredit etat;
     @NonNull private Simulation simulation;
     @NonNull private String remarks;
     @NonNull private int duree;
     private LocalDate date;
     @NonNull private Client client;
}
