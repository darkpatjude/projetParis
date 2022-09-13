import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Maillot } from '../model/maillot';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root'
})
export class MaillotService {
  static URL: string = 'http://localhost:8080/five/api/marchandise';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) { }
  public updateMaillot(maillot: Maillot): Observable<Maillot> {
    return this.httpClient.put<Maillot>(
      `${MaillotService.URL}/maillot/edit/${maillot.id}`,
      this.convert.maillotToJson(maillot)
    );
  }

  public createMaillot(maillot: Maillot): Observable<Maillot> {
    return this.httpClient.post<Maillot>(
      `${MaillotService.URL}/maillot`,
      this.convert.maillotToJson(maillot)
    );
  }

  public getMaillotById(id: number): Observable<Maillot> {
    return this.httpClient.get<Maillot>(`${MaillotService.URL}/maillot/${id}`);
  }
  
  public getAllMaillots(): Observable<Maillot[]> {
    return this.httpClient.get<Maillot[]>(`${MaillotService.URL}/maillot`);
  }
}
