package DTO;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "agence")
public class Agence {
    @Id
    private int code;
    @NonNull private String name;
    @NonNull private String adresse;
    @NonNull private String phone;
}
