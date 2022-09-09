import { Injectable } from '@angular/core';
import { Admin } from '../model/admin';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root',
})
export class ConvertService {
  constructor() {}

  public clientToJson(client: Client): any {
    let obj = {
      id: client.id_client,
      nom: client.nom,
      mail: client.mail,
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
      id: admin.id_admin,
      nom: admin.nom,
      mail: admin.mail,
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
}
