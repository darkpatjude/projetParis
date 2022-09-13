import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {

  observableClients: Observable<Client[]>;
  message = '';
  showMessage = false;

  constructor(private clientService: ClientService, private router:Router) {
    this.observableClients = this.clientService.getAll();
  }

  ngOnInit(): void {}

  delete(id: number) {
    this.clientService.deleteById(id).subscribe(() => {
      this.observableClients = this.clientService.getAll();
    });
  }

  editClient(id:number|undefined):void{
    this.router.navigateByUrl("client/edit/"+id)
}
newClient():void{
  this.router.navigateByUrl("inscription")
}
}
