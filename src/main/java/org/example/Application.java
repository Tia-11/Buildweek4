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
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        UtenteDAO us = new UtenteDAO(em);
        TesseraDAO ts = new TesseraDAO(em);

        Utente utente = new Utente("Maurizio","Crispino");
        Tessera tessera = new Tessera(LocalDate.parse("2012-06-22"), LocalDate.parse("2025-06-22"));
        utente.setTessera(tessera);

        ts.save(tessera);
        us.save(utente);

        System.out.println(utente);
        System.out.println(utente.getTessera());


    }
}
