package DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Simulation {
    @NonNull private double montant;
    @NonNull private double taux;
    @NonNull private int dure;
    @NonNull private double mensualite;
}
