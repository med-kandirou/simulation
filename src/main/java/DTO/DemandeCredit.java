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
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int number;
     private String etat="encours";
     @NonNull private double taux;
     @NonNull private double montant;
     @NonNull private double mensualite;
     @NonNull private int dure;
     @NonNull private String remarks;
     private LocalDate date=LocalDate.now();
     @ManyToOne
     @NonNull private Client client;
}
