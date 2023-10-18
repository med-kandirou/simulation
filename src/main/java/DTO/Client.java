package DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "client")
public class Client extends Personne{

    @Id
    @NonNull private String code;

    @Column(name = "adresse", nullable = false)
    @NonNull private String adresse;

    public Client(String code,String firstName, String lastName, LocalDate birthday,String phone,String adresse){
        super(firstName,lastName,birthday,phone);
        this.code=code;
        this.adresse=adresse;
    }
}
