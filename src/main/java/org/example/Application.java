package org.example;

import DAO.MezziDiTrasportoDAO;
import entities.MezzoDiTrasporto;
import entities.StatoDelMezzo;
import entities.TipoMezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.desktop.SystemEventListener;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Buildweek-4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        MezziDiTrasportoDAO mDao = new MezziDiTrasportoDAO(em);
        MezzoDiTrasporto mezzo1 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, 40, StatoDelMezzo.IN_MANUTENZIONE, LocalDate.parse("2023-06-24"));
        mDao.Save(mezzo1);









        Scanner scanner = new Scanner(System.in);
        //System.out.println("Inseriamo il mezzo di trasporto!");
        //nuovoMezzo(scanner);




    }

    public static void nuovoMezzo(Scanner scanner) {
        TipoMezzo tipoMezzo = null;
        int capienza = 0;
        StatoDelMezzo statoDelMezzo = null;
        System.out.println("Scrivi 'autobus' se il mezzo è un autobus, altrimenti 'tram' se è un tram");
        String mezzo = scanner.nextLine();

        switch (mezzo) {
            case "autobus" : {
                tipoMezzo = TipoMezzo.AUTOBUS;
                break;
            }
            case "tram" : {
                tipoMezzo = TipoMezzo.TRAM;
                break;
            }
            default: {
                System.err.println("Errore, mezzo non valido");
                nuovoMezzo(scanner);
            }
        }
        System.out.println("ora inseriamo la sua capienza");
        try {
            capienza = Integer.parseInt(scanner.nextLine());
            System.out.println("capienza mezzo : " + capienza);

        } catch (NumberFormatException exception) {
            System.err.println(exception + "Errore, non hai inserito un numero");
            nuovoMezzo(scanner);
        }
        System.out.println("Ora dimmi se il mezzo è in servizio (s) oppure in manutenzione (m)");
        String servizioOManutenzione = scanner.nextLine();
        switch (servizioOManutenzione) {
            case "s" : {
                System.out.println("mezzo in servizio");
                statoDelMezzo = StatoDelMezzo.IN_SERVIZIO;
                break;
            }
            case "m" : {
                statoDelMezzo = StatoDelMezzo.IN_MANUTENZIONE;
                break;
            }
            default: {
                System.err.println("il carattere inserito non corrisponde a 's' o 'm' riprova");
                nuovoMezzo(scanner);
            }
        }

        MezzoDiTrasporto mezzo1 = new MezzoDiTrasporto(tipoMezzo, capienza, statoDelMezzo);
        System.out.println(mezzo1);
    }

}
