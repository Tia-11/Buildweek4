package org.example;

import DAO.RivenditoreDAO;
import entities.Rivenditore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Buildweek-4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();


    }
}


