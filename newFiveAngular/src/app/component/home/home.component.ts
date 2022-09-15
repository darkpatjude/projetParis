import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  user: any = undefined;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    if (this.authService.authenticated) {
      this.user = JSON.parse(sessionStorage.getItem('user')!);
    }
  }
}
