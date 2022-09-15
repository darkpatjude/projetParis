import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { LigneDeCommande } from 'src/app/model/ligne-de-commande';
import { LigneDeCommandeKey } from 'src/app/model/ligne-de-commande-key';
import { CommandeService } from 'src/app/services/commande.service';

@Component({
  selector: 'app-commande-details',
  templateUrl: './commande-details.component.html',
  styleUrls: ['./commande-details.component.css']
})
export class CommandeDetailsComponent implements OnInit {
  //observableCommandes: Observable<LigneDeCommande[]>;
  message = '';
  showMessage = false;
  constructor(
    private commandeService: CommandeService,
    private activatedRoute: ActivatedRoute
  ) {
  //  this.observableCommandes = this.commandeService.getAll();
  }

  ngOnInit(): void {
    this.showMessage = false;
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `commande ${params['id']} créé`;
        } else {
          this.message = `commande ${params['id']} modifié`;
        }
        this.showMessage = true;
      }
    });
  }

}
