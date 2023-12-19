package org.example;

import DAO.TesseraDAO;
import DAO.UtenteDAO;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.desktop.SystemEventListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Application {


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Buildweek-4");

    public static void main(String[] args) {

        String nome="";
        String cognome;
        LocalDate dataEmissione;
        LocalDate dataScadenza;

        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        UtenteDAO us = new UtenteDAO(em);
        TesseraDAO ts = new TesseraDAO(em);

        System.out.println("Inizia la tua registrazione");
        System.out.println(" ");

        System.out.println("Inserisci il tuo nome");
        nome=scanner.nextLine();

        System.out.println("Inserisci il tuo cognome");
        cognome=scanner.nextLine();

        System.out.println("Inserisci la data di emissione della tua tessera secondo il formato (YYYY-MM-DD)");
        dataEmissione = LocalDate.parse(scanner.nextLine());

        System.out.println("Inserisci la data di scadenza della tua tessera secondo il formato (YYYY-MM-DD)");
        dataScadenza = LocalDate.parse(scanner.nextLine());

        Utente utente = new Utente(nome,cognome);
        Tessera tessera = new Tessera(dataEmissione, dataScadenza);
        utente.setTessera(tessera);

        ts.save(tessera);
        us.save(utente);

        System.out.println(utente);
        System.out.println(utente.getTessera());


    }
}
