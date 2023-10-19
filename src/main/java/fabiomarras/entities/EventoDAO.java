package fabiomarras.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class EventoDAO {
    private  final EntityManager em;
    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Evento s){
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(s);
    transaction.commit();
        System.out.println("Evento registrato con successo!!");
    }

    //METODO FIND per id
    public Evento findById(UUID id){
        return em.find(Evento.class, id);
    }

    //METODO DELETE per eliminare tramite id
    public  void findByIdAndDelete(UUID id){
        Evento found = em.find(Evento.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Evento rimosso con successo!");
        }
    }

    public void save1(Evento p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Nuovo evento salvato correttamente");
    }

    public List<Concerto> findAllTrue() {
        TypedQuery<Concerto> getAllQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = true", Concerto.class);
        System.out.println("Ecco i concerti in streaming: ");
        return getAllQuery.getResultList();
    }
    public List<Concerto> findAllConcertRock() {
        TypedQuery<Concerto> getAllQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.genereConcerto = 'ROCK'", Concerto.class);
        System.out.println("Ecco i concerti Rock: ");
        return getAllQuery.getResultList();
    }
    public List<PartitaDiCalcio> filterGaraPareggiato(){
        TypedQuery<PartitaDiCalcio> getAllQuery = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.vincente = null", PartitaDiCalcio.class);
        System.out.println("Ecco le partite pareggiate: ");
        return getAllQuery.getResultList();
    }
    public List<PartitaDiCalcio> filterEventiSoldOut(){
        TypedQuery<PartitaDiCalcio> getAllQuery = em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.numeroMassimoPartecipanti = p.spettatori", PartitaDiCalcio.class);
        System.out.println("Ecco gli Eventi Sold Out: ");
        return getAllQuery.getResultList();
    }
}
