import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {
  observableClients: Observable<Client[]>;
  message = '';
  showMessage = false;
  user: any = undefined;

  constructor(
    private clientService: ClientService,
    private router: Router,
    private authService: AuthService
  ) {
    this.observableClients = this.clientService.getAll();
  }

  ngOnInit(): void {
    if (this.authService.authenticated) {
      this.user = JSON.parse(sessionStorage.getItem('user')!);
    }
  }

  delete(id: number) {
    this.clientService.deleteById(id).subscribe(() => {
      this.observableClients = this.clientService.getAll();
    });
  }

  editClient(id: number | undefined): void {
    this.router.navigateByUrl('client/edit/' + id);
  }
  newClient(): void {
    this.router.navigateByUrl('inscription');
  }
}
