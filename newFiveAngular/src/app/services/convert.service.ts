import { Injectable } from '@angular/core';
import { Admin } from '../model/admin';
import { Client } from '../model/client';
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
}
