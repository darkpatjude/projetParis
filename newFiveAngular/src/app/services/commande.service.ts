import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Commande } from '../model/commande';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  static URL: string = 'http://localhost:8080/five/api/commande';

  constructor(
    private httpClient: HttpClient,

    private convert: ConvertService
  ) {}

  public getAll(): Observable<Commande[]> {
    return this.httpClient.get<Commande[]>(CommandeService.URL);
  }


  public getById(id: number): Observable<Commande> {
    return this.httpClient.get<Commande>(`${CommandeService.URL}/${id}`);
  }

  // public deleteById(id: number): Observable<void> {
  //   return this.httpClient.delete<void>(`${CommandeService.URL}/${id}`);
  // }

  // public update(commande: Commande): Observable<Commande> {
  //   return this.httpClient.put<Commande>(
  //     `${CommandeService.URL}/edit/${commande.id}`,
  //     this.convert.commandeToJson(commande)
  //   );
  // }


  public create(commande: Commande): Observable<Commande> {
    return this.httpClient.post<Commande>(
      CommandeService.URL,
      this.convert.commandeToJson(commande)
    );
  }

}
