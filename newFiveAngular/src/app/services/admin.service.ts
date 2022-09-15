import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../model/admin';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  static URL: string = 'http://localhost:8080/five/api/admin';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) {}

  public getAll(): Observable<Admin[]> {
    return this.httpClient.get<Admin[]>('http://localhost:8080/five/api/admin');
  }
  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      'http://localhost:8080/five/api/admin/' + id
    );
  }

  public getById(id: number): Observable<Admin> {
    return this.httpClient.get<Admin>(
      'http://localhost:8080/five/api/admin/' + id
    );
  }

  public update(admin: Admin): Observable<Admin> {
    return this.httpClient.put<Admin>(
      'http://localhost:8080/five/api/admin/' + admin.id,
      this.convert.adminToJson(admin)
    );
  }

  public create(admin: Admin): Observable<Admin> {
    return this.httpClient.post<Admin>(
      'http://localhost:8080/five/api/admin',
      this.convert.adminToJson(admin)
    );
  }
}
