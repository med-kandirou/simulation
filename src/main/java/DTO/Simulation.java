package DTO;

import lombok.*;

import java.text.DecimalFormat;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Simulation {
    @NonNull private double montant;
    @NonNull private double taux;
    @NonNull private int dure;
    private double mensualite;

    //validation au niveau de backend
    public void setMensualite() {
        this.taux=5.5;
        DecimalFormat df = new DecimalFormat("#.##");
        Double resultat = (this.montant * (this.taux / (12.0 * 100.0))) / (1 - Math.pow(1 + this.taux / (12.0 * 100.0), -this.dure));
        String formattedNumber = df.format(resultat);
        this.mensualite = Double.parseDouble(formattedNumber);
    }
}
