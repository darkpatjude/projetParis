import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Article } from 'src/app/model/article';
import { Maillot } from 'src/app/model/maillot';
import { LigneDeCommandeService } from 'src/app/services/ligne-de-commande.service';
import { MaillotService } from 'src/app/services/maillot.service';
import { MarchandiseService } from 'src/app/services/marchandise.service';
import { PanierService } from 'src/app/services/panier.service';

@Component({
  selector: 'app-maillot-list',
  templateUrl: './maillot-list.component.html',
  styleUrls: ['./maillot-list.component.css']
})
export class MaillotListComponent implements OnInit {
  observableMaillots: Observable<Maillot[]>;
  message = '';
  showMessage = false;
  constructor(
    private marchandiseService: MarchandiseService,
    private maillotService: MaillotService,
    private activatedRoute: ActivatedRoute,
    private lignedecommandeService: LigneDeCommandeService
  ) {
    this.observableMaillots = this.maillotService.getAllMaillots();
  }
    
  @Output()
  event = new EventEmitter();

  ngOnInit(): void {
    this.showMessage = false;
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `marchandise ${params['id']} créé`;
        } else {
          this.message = `marchandise ${params['id']} modifié`;
        }
        this.showMessage = true;
      }
    });
  }

  delete(id: number) {
    this.marchandiseService.deleteById(id).subscribe(() => {
      this.observableMaillots = this.maillotService.getAllMaillots();
    });
  }

  addtocart(maillot: Maillot){
    this.lignedecommandeService.addtoCart(maillot);
  }
} 
