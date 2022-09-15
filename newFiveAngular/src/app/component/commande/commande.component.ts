import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Commande } from 'src/app/model/commande';
import { CommandeService } from 'src/app/services/commande.service';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {

  observableCommandes: Observable<Commande[]>;
  message = '';
  showMessage = false;
  constructor(
    private commandeService: CommandeService,
    private activatedRoute: ActivatedRoute
  ) {
    this.observableCommandes = this.commandeService.getAll();
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

  // delete(id: number) {
  //   this.commandeService.deleteById(id).subscribe(() => {
  //     this.observableCommandes = this.commandeService.getAll();
  //   });
  // }


}


