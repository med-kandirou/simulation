package DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public abstract class Personne {

    @NonNull protected String firstName;
    @NonNull protected String lastName;
    @NonNull protected LocalDate birthday;
    @NonNull protected String phone;

}
