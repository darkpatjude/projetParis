import { Component, OnInit } from '@angular/core';
import {  ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';
@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  client: Client;
  mdp !: string;
  mdpConf!:string;
  httpClient: any;
  constructor(
    private ar: ActivatedRoute,
    private clientService: ClientService,
    private router: Router
  ) {
    this.client = new Client();
  }

  ngOnInit(): void {

  }
  annuler(){
    this.router.navigateByUrl('/clients');
  }
  save() {

    if(this.mdp===this.mdpConf){
      this.clientService.create(this.client).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/client/edit/'+result.id);
          //this.router.navigateByUrl('/client?q=create&id='+result.id)
        },
        error: (err) => {
          console.log(err);
        },
      });}
      else{
        alert("mot de passe non conforme")
      }

}
}
