package org.example;

import DAO.InManutenzioneDAO;
import DAO.MezziDiTrasportoDAO;
import DAO.TratteDAO;
import entities.*;

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
        InManutenzioneDAO iDao = new InManutenzioneDAO(em);

        //MezzoDiTrasporto mezzo1 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, 29, StatoDelMezzo.IN_MANUTENZIONE, LocalDate.parse("2020-11-02"));
        //mDao.Save(mezzo1);
        //mDao.FindByIdAndDelete(7);

        //Tratta tratta1 = new Tratta("Galzignano Terme", "Este", 10.8);
        //tDao.Save(tratta1);
        //tratta1.setMezziDiTrasporto();
        //InManutenzione manutenzione1 = new InManutenzione(LocalDate.parse("2021-03-28"), LocalDate.parse("2022-04-01"), mDao.FindById(12));
        //System.out.println(manutenzione1);
        //iDao.Save(manutenzione1);
        //System.out.println(mDao.FindById(6));


        Tratta trattaProva = tDao.FindById(4);
        Tratta trattaProva2 = tDao.FindById(3);
        Tratta trattaProva3 = tDao.FindById(5);
        MezzoDiTrasporto mezzoProva = mDao.FindById(12);
        //System.out.println(trattaProva3.getMezziDiTrasporto());
        //mezzoProva.setInizioServizio(LocalDate.parse("2016-02-14"));
        //mDao.Save(mezzoProva);
        //mezzoProva.setTratta(new ArrayList<>(Arrays.asList(trattaProva3))); // perché se aggiungo una sola tratta da errore?
        //mDao.Save(mezzoProva);  // quindi questa operazione è una specie di PUT?
        //System.out.println(trattaProva2);

        //PROVE NAMED QUERY ----------------
        System.out.println("NAMED QUERY");
        System.out.println("RICERCA PER TIPOLOGIA MEZZO");
        System.out.println("ricerca per tipologia TRAM --------------");
        mDao.findByType(TipoMezzo.TRAM).forEach(mezzo -> System.out.println(mezzo));
        System.out.println("ricerca per tipologia AUTOBUS --------------");
        mDao.findByType(TipoMezzo.AUTOBUS).forEach(mezzo -> System.out.println(mezzo));

        System.out.println("RICERCA PER STATO DEL MEZZO");
        System.out.println("ricerca per stato IN SERVIZIO");
        mDao.findByStatoDelMezzo(StatoDelMezzo.IN_SERVIZIO).forEach(mezzo -> System.out.println(mezzo));
        System.out.println("ricerca per stato IN MANUTENZIONE");
        mDao.findByStatoDelMezzo(StatoDelMezzo.IN_MANUTENZIONE).forEach(mezzo -> System.out.println(mezzo));

        // PROVE QUERY --------------------
        System.out.println("QUERY ANONIME");
        System.out.println("TUTTI I VEICOLI");
        mDao.findAllVehicles().forEach(vehicle -> System.out.println(vehicle));

        System.out.println("TUTTE LE MANUTENZIONI");
        iDao.findAllMaintenances().forEach(maintenance -> System.out.println(maintenance));

        System.out.println("MANUTENZIONI DATO UN PERIODO");
        iDao.findByDate(LocalDate.parse("2022-09-01"), LocalDate.parse("2023-12-31")).forEach(maintenance -> System.out.println(maintenance));

        System.out.println("TUTTE LE TRATTE");
        tDao.findAllTratte().forEach(tratta -> System.out.println(tratta));




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
