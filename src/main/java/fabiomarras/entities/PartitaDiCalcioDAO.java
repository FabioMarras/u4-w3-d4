package fabiomarras.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class PartitaDiCalcioDAO {
    private  final EntityManager em;
    public PartitaDiCalcioDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(PartitaDiCalcio s){
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(s);
    transaction.commit();
        System.out.println("Location registrata con successo!!");
    }

    //METODO FIND per id
    public PartitaDiCalcio findById(UUID id){
        return em.find(PartitaDiCalcio.class, id);
    }

    //METODO DELETE per eliminare tramite id
    public void findByIdAndDelete(UUID id){
        PartitaDiCalcio found = em.find(PartitaDiCalcio.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Location rimossa con successo!");
        }
    }
    public List<PartitaDiCalcio> filterGaraDiAtleticaWon(){
        TypedQuery<PartitaDiCalcio> getVincitore = em.createNamedQuery("gameWonHome", PartitaDiCalcio.class);
        return getVincitore.getResultList();
    }
    public List<PartitaDiCalcio> filterGaraDiAtleticaLose(){
        TypedQuery<PartitaDiCalcio> getVincitore = em.createNamedQuery("gameWonguests", PartitaDiCalcio.class);
        return getVincitore.getResultList();
    }
}
