package fivefoot.entities;

import java.util.*;

/**
 * 
 */
public class Client extends Utilisateur {

    /**
     * Default constructor
     */
    public Client() {
    }

    /**
     * 
     */
    private Long id_client;

    /**
     * 
     */
    private Set<Commande> commande;

    /**
     * 
     */
    public HashSet<Marchandise> historiqueAchat;

    /**
     * 
     */
    private final Date dateCreation;

    /**
     * 
     */
    private HashSet<Commande> Commande;

    /**
     * 
     */
    public void creerCompte() {
        // TODO implement here
    }

    /**
     * 
     */
    public void supprimerCompteClient() {
        // TODO implement here
    }

    /**
     * 
     */
    public void updateCompteClient() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getHistoriqueCommande() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getHistoriqueAchat() {
        // TODO implement here
    }

    /**
     * 
     */
    public void authentification() {
        // TODO implement here
    }

}