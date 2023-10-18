package DTO;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Personne {
    @NonNull protected String firstName;
    @NonNull protected String lastName;
    @NonNull protected LocalDate birthday;
    @NonNull protected String phone;

}