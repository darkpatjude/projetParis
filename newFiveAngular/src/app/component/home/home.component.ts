import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
 // clients: Client[] = [];
  //constructor(private clientService: ClientService) {}

  ngOnInit(): void {
   // this.list();
  }
 /* list() {
    this.clientService.getAll().subscribe((result) => {
      this.clients = result;
    });
  }*/
}
