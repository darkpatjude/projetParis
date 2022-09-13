import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ballon } from '../model/ballon';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root'
})
export class BallonService {
  static URL: string = 'http://localhost:8080/five/api/marchandise';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) { }
  public updateBallon(ballon: Ballon): Observable<Ballon> {
    return this.httpClient.put<Ballon>(
      `${BallonService.URL}/ballon/edit/${ballon.id}`,
      this.convert.ballonToJson(ballon)
    );
  }

  public createBallon(ballon: Ballon): Observable<Ballon> {
    return this.httpClient.post<Ballon>(
      `${BallonService.URL}/ballon`,
      this.convert.ballonToJson(ballon)
    );
  }

  public getBallonById(id: number): Observable<Ballon> {
    return this.httpClient.get<Ballon>(`${BallonService.URL}/ballon/${id}`);
  }
  
  public getAllBallons(): Observable<Ballon[]> {
    return this.httpClient.get<Ballon[]>(`${BallonService.URL}/ballon`);
  }
}
