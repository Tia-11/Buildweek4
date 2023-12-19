package org.example;

import entities.MezzoDiTrasporto;
import entities.StatoDelMezzo;
import entities.TipoMezzo;

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
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("Inseriamo il mezzo di trasporto!");
        System.out.println("Scrivi 'autobus' se il mezzo è un autobus, altrimenti 'tram' se è un tram");
        String mezzo = scanner.nextLine();
        qualeTrasporto(mezzo);
        System.out.println("Ora dimmi se il mezzo è in servizio (s) oppure in manutenzione (m)");
        String servizioOManutenzione = scanner.nextLine();*/
        long date = new Date().getYear()+ 1900;
        System.out.println(date);


        MezzoDiTrasporto autobus1 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, 34, StatoDelMezzo.IN_SERVIZIO);

        System.out.println(autobus1);



    }

    public static void qualeTrasporto(String mezzo) {
        if (!mezzo.equals("autobus") && !mezzo.equals("tram")) {
            System.err.println("mezzo non valido, riprova");
            qualeTrasporto(mezzo);
        } else {
            System.out.println("mezzo inserito : " + mezzo);
        }
    }

}
