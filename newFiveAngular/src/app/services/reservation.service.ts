import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConvertService } from './convert.service';
import { Observable } from 'rxjs';
import { Reservation } from '../model/reservation';

@Injectable({
  providedIn: 'root'
})

export class ReservationService {
  [x: string]: any;
  static URL: string = 'http://localhost:8080/five/api/reservation';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService) {}

      public getAll(): Observable<Reservation[]> {
        return this.httpClient.get<Reservation[]>(ReservationService.URL);
      }

      public getById(id: number): Observable<Reservation> {
        return this.httpClient.get<Reservation>(`${ReservationService.URL}/${id}`);
      }

      public deleteById(id: number): Observable<void> {
        return this.httpClient.delete<void>(`${ReservationService.URL}/${id}`);
      }

      public update(reservation: Reservation): Observable<Reservation> {
        return this.httpClient.put<Reservation>(
          'http://localhost:8080/five/api/reservation/' + reservation.id,
          this.convert.reservationToJson(reservation)
        );
      }

      public create(reservation: Reservation): Observable<Reservation> {
        return this.httpClient.post<Reservation>(
          ReservationService.URL,
          this.convert.reservationToJson(reservation)
        );
      }
}
