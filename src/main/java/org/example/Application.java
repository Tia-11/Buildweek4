package org.example;

import DAO.MezziDiTrasportoDAO;
import DAO.TratteDAO;
import entities.MezzoDiTrasporto;
import entities.StatoDelMezzo;
import entities.TipoMezzo;
import entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.desktop.SystemEventListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Buildweek-4");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        MezziDiTrasportoDAO mDao = new MezziDiTrasportoDAO(em);
        TratteDAO tDao = new TratteDAO(em);

        MezzoDiTrasporto mezzo1 = new MezzoDiTrasporto(TipoMezzo.TRAM, 33, StatoDelMezzo.IN_SERVIZIO, LocalDate.parse("2017-03-12"));
        //mDao.Save(mezzo1);
        mDao.findByIdAndDelete(7);

        Tratta tratta1 = new Tratta("Galzignano Terme", "Este", 10.8);
        //tDao.Save(tratta1);
        //tratta1.setMezziDiTrasporto();



        //System.out.println(tDao.findById(4));
        Tratta trattaProva = tDao.findById(4);
        Tratta trattaProva2 = tDao.findById(3);
        Tratta trattaProva3 = tDao.findById(5);
        MezzoDiTrasporto mezzoProva = mDao.findById(6);
        //System.out.println(mezzoProva);

        mezzoProva.setTratta(new ArrayList<>(Arrays.asList(trattaProva3, trattaProva2)));
        //mDao.Save(mezzoProva);  // quindi questa operazione è una specie di PUT?
        System.out.println(trattaProva2);







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
