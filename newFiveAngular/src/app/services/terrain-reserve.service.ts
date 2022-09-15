import { TerrainReserve } from './../model/terrainReserve';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConvertService } from './convert.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TerrainReserveService {

  static URL: string = 'http://localhost:8080/five/api/terrain';


  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService) {}


      public getAll(): Observable<TerrainReserve[]> {
        return this.httpClient.get<TerrainReserve[]>(TerrainReserveService.URL);
      }

      public getById(id: number): Observable<TerrainReserve> {
        return this.httpClient.get<TerrainReserve>(`${TerrainReserveService.URL}/${id}`);
      }

      public deleteById(id: number): Observable<void> {
        return this.httpClient.delete<void>(`${TerrainReserveService.URL}/${id}`);
      }

      public update(terrainReserve: TerrainReserve): Observable<TerrainReserve> {
        return this.httpClient.put<TerrainReserve>(
          TerrainReserveService.URL +'/'+ terrainReserve.id,
          this.convert.terrainReserveToJson(terrainReserve)
        );
      }

      public create(terrainReserve: TerrainReserve): Observable<TerrainReserve> {
        return this.httpClient.post<TerrainReserve>(
          TerrainReserveService.URL,
          this.convert.terrainReserveToJson(terrainReserve)
        );
      }
    }
