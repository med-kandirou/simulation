package DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "historique")
public class Historique {
    @Id
    private int id;
    private int demande_id;
    private String ancien_statut;
    private String nouveau_statut;
    private Timestamp date_modification;
}
