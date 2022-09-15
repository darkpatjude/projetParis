import { Injectable } from '@angular/core';
import { Admin } from '../model/admin';
import { Article } from '../model/article';
import { Ballon } from '../model/ballon';
import { Client } from '../model/client';
import { Commande } from '../model/commande';
import { LigneDeCommande } from '../model/ligne-de-commande';
import { Maillot } from '../model/maillot';
import { Marchandise } from '../model/marchandise';
import { Reservation } from '../model/reservation';

@Injectable({
  providedIn: 'root',
})
export class ConvertService {
  constructor() {}

  public clientToJson(client: Client): any {
    let obj = {
      id: client.id,
      nom: client.nom,
      email: client.email,
      prenom: client.prenom,
      telephone: client.telephone,
    };

    if (client.adresse) {
      Object.assign(obj, {
        adresse: {
          numero: client.adresse.numero,
          rue: client.adresse.rue,
          codePostal: client.adresse.codePostal,
          ville: client.adresse.ville,
        },
      });
    }
    return obj;
  }

  public adminToJson(admin: Admin): any {
    let obj = {
      id: admin.id,
      nom: admin.nom,
      email: admin.email,
      prenom: admin.prenom,
      telephone: admin.telephone,
    };

    if (admin.adresse) {
      Object.assign(obj, {
        adresse: {
          numero: admin.adresse.numero,
          rue: admin.adresse.rue,
          codePostal: admin.adresse.codePostal,
          ville: admin.adresse.ville,
        },
      });
    }
    return obj;
  }
  public reservationToJson(reservation: Reservation): any {
    let obj = {
      id: reservation.id,
      prix: reservation.prix,
      terrainReserve: reservation.terrainReserve,
      date: reservation.date,
      heure: reservation.heure
    };

    if (reservation.terrainReserve) {
      Object.assign(obj, {
        terrainReserve: {
          id: reservation.terrainReserve.id,
          nom: reservation.terrainReserve.nom,
          heureFermeture: reservation.terrainReserve.heureFermeture,
          heureOuverture: reservation.terrainReserve.heureOuverture,
        },
      });
    }
    return obj;
  }
  
  public articleToJson(article: Article): any {
    let obj = {
      id: article.id,
      prix: article.prix,
    };
    return obj;
  }

  public lignedeCommandeToJson(lignedeCommande: LigneDeCommande): any {
    let obj = {
      id: lignedeCommande.id,
      quantite: lignedeCommande.quantite,
    };
    return obj;
  }


  public commandeToJson(commande: Commande): any {
    let obj = {
      id: commande.id,
      client: commande.client,
      prix: commande.prix,
      date: commande.date,
      lignes: commande.ligne
    };
    if (commande.ligne) {
        Object.assign(obj, {
         ligne: {
         id: commande.ligne.id,
         quantite: commande.ligne.quantite
          },
     });
     if (commande.client) {
      Object.assign(obj, {
       client: {
       id: commande.client.id,
      nom: commande.client.nom,
      email: commande.client.email,
      prenom: commande.client.prenom,
      telephone: commande.client.telephone,

        },
   });
    return obj;
  }}}

  public marchandiseToJson(marchandise: Marchandise): any {
    let obj = {
      prix: marchandise.prix,
      nom: marchandise.nom,
      stock: marchandise.stock,
      description: marchandise.description,
      maillot: marchandise.maillot,
      ballon: marchandise.ballon
    };
    // if (marchandise.ballon) {
    //   Object.assign(obj, {
    //     ballon: {
    //       couleur: marchandise.ballon.couleur,
    //       taille: marchandise.ballon.taille
    //     },
    //   });
    // } if (marchandise.maillot) {
    //   Object.assign(obj, {
    //     maillot: {
    //       equipe: marchandise.maillot.equipe,
    //      taille: marchandise.maillot.taille
    //     },
    //   });
    // }
     return obj;
  
  }

  public ballonToJson(ballon: Ballon): any {
    let obj = {
      prix: ballon.prix,
      nom: ballon.nom,
      stock: ballon.stock,
      description: ballon.description,
      couleur: ballon.couleur,
      taille: ballon.taille,
      ballon: ballon,
      maillot: ballon.maillot
        };
        return obj;
      }

      public maillotToJson(maillot: Maillot): any {
        let obj = {
          prix: maillot.prix,
          nom: maillot.nom,
          stock: maillot.stock,
          description: maillot.description,
          equipe: maillot.equipe, 
          taille: maillot.taille,
          maillot: maillot,
          ballon: maillot.ballon
            };
            return obj;
          }
}
