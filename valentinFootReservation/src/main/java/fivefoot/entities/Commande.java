package fivefoot.entities;

import java.util.*;

/**
 * 
 */
public class Commande {

    /**
     * Default constructor
     */
    public Commande() {
    }

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Long id_commande;

    /**
     * 
     */
    private double prix;

    /**
     * 
     */
    private Set<LigneDeCommande> lignes;

    /**
     * 
     */
    public Set<Reservation> reservationsEffectuee;

    /**
     * 
     */
    public void infos() {
        // TODO implement here
    }

    /**
     * 
     */
    public void recommander() {
        // TODO implement here
    }

}