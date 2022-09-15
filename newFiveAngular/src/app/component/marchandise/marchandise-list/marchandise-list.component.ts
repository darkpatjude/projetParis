import { BallonService } from './../../../services/ballon.service';
import { MaillotService } from './../../../services/maillot.service';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { map, Observable, tap } from 'rxjs';
import { Marchandise } from 'src/app/model/marchandise';
import { MarchandiseService } from 'src/app/services/marchandise.service';
import { Ballon } from 'src/app/model/ballon';
import { PanierService } from 'src/app/services/panier.service';

@Component({
  selector: 'app-marchandise-list',
  templateUrl: './marchandise-list.component.html',
  styleUrls: ['./marchandise-list.component.css']
})
export class MarchandiseListComponent implements OnInit {
  observableMarchandises: Observable<Marchandise[]>;
  message = '';
  showMessage = false;
  oui!:boolean
  stat$!:Observable<string>;
  @Output()
  event = new EventEmitter();
  constructor(
    private marchandiseService: MarchandiseService,
    private maillotService: MaillotService,
    private ballonService:BallonService,
    private activatedRoute: ActivatedRoute,
    private router:Router,
    private panierService: PanierService,
  ) {
    this.observableMarchandises = this.marchandiseService.getAll();
  }

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

  view(id:number){

    this.ballonService.getBallonById(id).pipe(
      map(value=>{if(value){this.router.navigateByUrl(`/marchandise/ballon/${id}`)}else{{this.router.navigateByUrl(`/marchandise/ballon/${id}`)}}})
    ).subscribe()
    this.maillotService.getMaillotById(id).pipe(
      map(value=>{if(value){this.router.navigateByUrl(`/marchandise/maillot/${id}`)}})
    ).subscribe()
  }
  addToCart(marchandise: Marchandise) {
    this.panierService.addtoCart(marchandise);
   // this.router.navigateByUrl("/panier")
  }
}
