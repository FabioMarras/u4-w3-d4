package fabiomarras;

import fabiomarras.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
        EventoDAO sd = new EventoDAO(em);
        PersonDAO pd = new PersonDAO(em);
        PartecipazioneDAO ppd = new PartecipazioneDAO(em);
        LocationDAO ld = new LocationDAO(em);

        // SAVE per salvare un nuovo evento
        Person User = new Person("Fabio","Marras", "fabio@gmail.com" , LocalDate.now(),Genres.M);
        //pd.save(User);
            Partecipazione p1 = new Partecipazione(Status.DA_CONFERMARE);
            //ppd.save(p1);
            Location l1 = new Location("Spa", "Belgio");
            //ld.save(l1);

            /*Evento findById = sd.findById(UUID.fromString("a96753a2-1e80-4798-850c-ad81f7aaf8eb"));
            if (findById != null) {
                System.out.println(findById);
            } else {
                System.out.println("non ho trovato niente");
            }*/

        //pd.findByIdAndDelete(UUID.fromString("d3c826fc-afb1-4554-92a8-80cbe4636a23"));

           //Location cagliari = ld.findById(UUID.fromString("4720ab9d-670b-4a15-bc1a-16f5c85002f5"));
           /*Location belgio = ld.findById(UUID.fromString("bba346e8-0cd2-4569-b6ce-b9346e824b65"));

           Evento race = sd.findById(UUID.fromString("a96753a2-1e80-4798-850c-ad81f7aaf8eb"));

            if (belgio != null) {
                race.setLocations(new HashSet<>(Arrays.asList(belgio)));
                sd.save(race);
            }

            System.out.println("Location per l'evento race: ");
            race.getLocations().forEach(System.out::println);

            System.out.println("Evento per la gara in belgio: ");
            belgio.getEvents().forEach(System.out::println);

            Person fabio = pd.findById(UUID.fromString("414cf218-fe29-4fe1-b1b6-e56c6351cafb"));
            Person alfonso = pd.findById(UUID.fromString("40a3ca6b-e033-42c3-9e59-eca5f511ff37"));
            Partecipazione frompublic = ppd.findById(UUID.fromString("227bcb90-517d-4204-970f-3ddd029847cf"));

            if (fabio != null) {
                frompublic.setPerson(new HashSet<>(Arrays.asList(fabio, alfonso)));
                ppd.save(frompublic);
            }

            System.out.println("Partecipazioni per l'evento: ");
            frompublic.getPerson().forEach(System.out::println);

            if (fabio != null ) {
                race.setPartecipazione(new HashSet<>(Arrays.asList(frompublic)));
                ppd.save(frompublic);
            }

            System.out.println("Questo è il dettaglio di race: ");
            System.out.println(race);*/

            PartitaDiCalcio primaPartita = new PartitaDiCalcio("Cagliari", "Cesena", "Cagliari" , 1, 0);
            //Concerto primoConcerto = new Concerto(genereConcerto.ROCK, true);

            //sd.save1(primaPartita);
            //sd.save1(primoConcerto);

            Evento vincitore = em.find(Evento.class, UUID.fromString("36845c42-f103-4438-96a8-b1f22554e986"));

            List<Person> atleti = new ArrayList<>();
            atleti.add(pd.findById(UUID.fromString("36845c42-f103-4438-96a8-b1f22554e986")));
            atleti.add(pd.findById(UUID.fromString("ce38db99-6be7-468f-bb7b-6db19dfb5ff0")));

            GaraDiAtletica primaGara = new GaraDiAtletica("Gara1", "01/01/2012","prima Gara",TipoEvento.PUBBLICO,50,vincitore,atleti);
            //sd.save1(primaGara);
            //System.out.println(primaGara);

            Concerto concertoPrimo = new Concerto("Concerto dal vivo", "27/10/2023", "Concerto +18", TipoEvento.PRIVATO, 50, genereConcerto.CLASSICO, true);
            //sd.save1(concertoPrimo);

            Evento mio = sd.findById(UUID.fromString("f086854e-c0c5-4312-aca8-eed057979a00"));
            //System.out.println(mio);

            sd.findAllTrue().forEach(System.out::println);
            sd.findAllConcertRock().forEach(System.out::println);

        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
        em.close();
        emf.close();
        }
    }
}
