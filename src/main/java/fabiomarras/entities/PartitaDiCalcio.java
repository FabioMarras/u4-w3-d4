package fabiomarras.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PartitaDiCalcio")
public class PartitaDiCalcio extends Evento{
    private String squadraDiCasa;
    private String ospite;
    private String vincente;
    private int numGoalCasa;
    private int numGoalOspite;

    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String squadraDiCasa, String ospite, String vincente, int numGoalCasa, int numGoalOspite) {
        this.squadraDiCasa = squadraDiCasa;
        this.ospite = ospite;
        this.vincente = vincente;
        this.numGoalCasa = numGoalCasa;
        this.numGoalOspite = numGoalOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getOspite() {
        return ospite;
    }

    public void setOspite(String ospite) {
        this.ospite = ospite;
    }

    public String getVincente() {
        return vincente;
    }

    public void setVincente(String vincente) {
        this.vincente = vincente;
    }

    public int getNumGoalCasa() {
        return numGoalCasa;
    }

    public void setNumGoalCasa(int numGoalCasa) {
        this.numGoalCasa = numGoalCasa;
    }

    public int getNumGoalOspite() {
        return numGoalOspite;
    }

    public void setNumGoalOspite(int numGoalOspite) {
        this.numGoalOspite = numGoalOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", ospite='" + ospite + '\'' +
                ", vincente='" + vincente + '\'' +
                ", numGoalCasa=" + numGoalCasa +
                ", numGoalOspite=" + numGoalOspite +
                '}';
    }
}
