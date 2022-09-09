import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  static URL: string = 'http://localhost:8080/five/api/client';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) {}

  public getAll(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(
      'http://localhost:8080/five/api/client'
    );
  }
  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      'http://localhost:8080/eshop/api/fournisseur/' + id
    );
  }

  public getById(id: number): Observable<Client> {
    return this.httpClient.get<Client>(
      'http://localhost:8080/eshop/api/fournisseur/' + id
    );
  }

  public update(client: Client): Observable<Fournisseur> {
    return this.httpClient.put<Client>(
      'http://localhost:8080/eshop/api/fournisseur/' + fournisseur.id,
      this.convert.clientToJson(client)
    );
  }

  public create(fournisseur: Client): Observable<Fournisseur> {
    return this.httpClient.post<Client>(
      'http://localhost:8080/eshop/api/fournisseur',
      this.convert.clientToJson(client)
    );
  }
}
