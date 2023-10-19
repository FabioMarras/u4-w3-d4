package fabiomarras.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("GaraDiAtletica")
public class GaraDiAtletica extends Evento {
    //private set<person> atleti;
    //private String vincitore;

    @OneToOne()
    @JoinColumn(name = "vincitore")
    private Evento vincitore;

    @OneToMany()
    private List<Person> atleti;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, String dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti, Evento vincitore, List<Person> atleti) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.vincitore = vincitore;
        this.atleti = atleti;
    }

    public Evento getVincitore() {
        return vincitore;
    }

    public void setVincitore(Evento vincitore) {
        this.vincitore = vincitore;
    }

    public List<Person> getAtleti() {
        return atleti;
    }

    public void setAtleti(List<Person> atleti) {
        this.atleti = atleti;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "vincitore=" + vincitore +
                ", atleti=" + atleti +
                '}';
    }
}
