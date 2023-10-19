package fabiomarras.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "events")
@DiscriminatorColumn(name = "tipo_evento")
public abstract class Evento {
    @Id
    @GeneratedValue
    private UUID id;
    private String titolo;
    private String dataEvento;
    private String descrizione;
    //private String tipoEvento;
    @Enumerated(EnumType.STRING)

    private TipoEvento tipoEvento;
    private int numeroMassimoPartecipanti;
    private int spettatori;

    @ManyToMany
    @JoinTable(name = "event_location", joinColumns = @JoinColumn(name = "event_id"),
    inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> locations;
    @ManyToMany
    @JoinTable(name = "partecipazione_event", joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "partecipazione_id"))
    private Set<Partecipazione> partecipazione;

    @OneToOne(mappedBy = "evento")
    private Location location;

    public Evento(){}

    public Evento(String titolo, String dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, int spettatori) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.spettatori = spettatori;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public Set<Partecipazione> getPartecipazione() {
        return partecipazione;
    }

    public void setPartecipazione(Set<Partecipazione> partecipazione) {
        this.partecipazione = partecipazione;
    }

    public int getSpettatori() {
        return spettatori;
    }

    public void setSpettatori(int spettatori) {
        this.spettatori = spettatori;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento='" + dataEvento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", spettatori=" + spettatori +
                ", locations=" + locations +
                ", partecipazione=" + partecipazione +
                ", location=" + location +
                '}';
    }
}
