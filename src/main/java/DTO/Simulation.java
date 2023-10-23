package DTO;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Simulation {
    @NonNull private double montant;
    @NonNull private double taux;
    @NonNull private int dure;
    private double mensualite;

    public void setMensualite() {
        this.taux = 5.5;
        double resultat = (this.montant * (this.taux / (12.0 * 100.0))) / (1 - Math.pow(1 + this.taux / (12.0 * 100.0), -this.dure));
        BigDecimal decimalResultat = BigDecimal.valueOf(resultat);
        decimalResultat = decimalResultat.setScale(2, RoundingMode.HALF_UP);
        this.mensualite = decimalResultat.doubleValue();
    }






}
