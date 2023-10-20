package DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "client")
public class Client extends Personne{
    @Id
    @NonNull private String code;
    @NonNull private String adresse;

    public Client(String code,String firstName, String lastName, LocalDate birthday,String phone,String adresse){
        super(firstName,lastName,birthday,phone);
        this.code=code;
        this.adresse=adresse;
    }
}