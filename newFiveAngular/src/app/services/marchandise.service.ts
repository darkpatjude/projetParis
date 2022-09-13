import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ballon } from '../model/ballon';
import { Maillot } from '../model/maillot';
import { Marchandise } from '../model/marchandise';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root'
})
export class MarchandiseService {
  static URL: string = 'http://localhost:8080/five/api/marchandise';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) {}

  public getAll(): Observable<Marchandise[]> {
    return this.httpClient.get<Marchandise[]>(MarchandiseService.URL);
  }

  public getAllMaillots(): Observable<Marchandise[]> {
    return this.httpClient.get<Marchandise[]>(`${MarchandiseService.URL}/maillot`);
  }

  public getAllBallons(): Observable<Ballon[]> {
    return this.httpClient.get<Ballon[]>(`${MarchandiseService.URL}/ballon`);
  }


  public getById(id: number): Observable<Marchandise> {
    return this.httpClient.get<Marchandise>(`${MarchandiseService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${MarchandiseService.URL}/${id}`);
  }

  public update(marchandise: Marchandise): Observable<Marchandise> {
    return this.httpClient.put<Marchandise>(
      `${MarchandiseService.URL}/${marchandise.id}`,
      this.convert.marchandiseToJson(marchandise)
    );
  }

  public createBallon(ballon: Ballon): Observable<Ballon> {
    return this.httpClient.post<Ballon>(
      `${MarchandiseService.URL}/ballon`,
      this.convert.marchandiseToJson(ballon)
    );
  }
  public createMaillot(maillot: Maillot): Observable<Maillot> {
    return this.httpClient.post<Maillot>(
      `${MarchandiseService.URL}/maillot`,
      this.convert.marchandiseToJson(maillot)
    );
  }
  public create(marchandise: Marchandise): Observable<Marchandise> {
    return this.httpClient.post<Marchandise>(
      MarchandiseService.URL,
      this.convert.marchandiseToJson(marchandise)
    );
  }

  public getBallonById(id: number): Observable<Ballon> {
    return this.httpClient.get<Ballon>(`${MarchandiseService.URL}/ballon/${id}`);
  }
  public getMaillotById(id: number): Observable<Maillot> {
    return this.httpClient.get<Maillot>(`${MarchandiseService.URL}/maillot/${id}`);
  }
}
