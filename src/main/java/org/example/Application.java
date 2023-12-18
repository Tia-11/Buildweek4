package org.example;

import entities.MezzoDiTrasporto;
import entities.StatoDelMezzo;
import entities.TipoMezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Buildweek-4");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();

        MezzoDiTrasporto autobus1 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, 34, StatoDelMezzo.IN_SERVIZIO, LocalDate.parse("2023-06-16"), LocalDate.now());

        System.out.println(autobus1);
    }
}
