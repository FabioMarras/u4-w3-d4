package fabiomarras.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Concerto")
public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private genereConcerto genereConcerto;
    private boolean inStreaming;

    public Concerto(){}

    public Concerto(String titolo, String dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti, fabiomarras.entities.genereConcerto genereConcerto, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genereConcerto = genereConcerto;
        this.inStreaming = inStreaming;
    }

    public fabiomarras.entities.genereConcerto getGenereConcerto() {
        return genereConcerto;
    }

    public void setGenereConcerto(fabiomarras.entities.genereConcerto genereConcerto) {
        this.genereConcerto = genereConcerto;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "id=" + getId() +
                ", titolo='" + getTitolo() + '\'' +
                ", dataEvento='" + getDataEvento() + '\'' +
                ", descrizione='" + getDescrizione() + '\'' +
                ", tipoEvento=" + getTipoEvento() +
                ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti() +
                ", genereConcerto=" + getGenereConcerto() +
                ", inStreaming=" + isInStreaming() +
                '}';
    }
}
