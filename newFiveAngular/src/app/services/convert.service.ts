import { Injectable } from '@angular/core';
import { Admin } from '../model/admin';
import { Client } from '../model/client';
import { Reservation } from '../model/reservation';

@Injectable({
  providedIn: 'root',
})
export class ConvertService {
  produitToJson(reservation: Reservation): any {
    throw new Error('Method not implemented.');
  }
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
      terrainReserve: reservation.terrain,
      date: reservation.date,
      heure: reservation.heure
    };

    if (reservation.terrain) {
      Object.assign(obj, {
        terrain: {
          id: reservation.terrain.id,
          nom: reservation.terrain.nom,
          heureFermeture: reservation.terrain.heureFermeture,
          heureOuverture: reservation.terrain.heureOuverture,
        },
      });
    }
    return obj;
  }
}
