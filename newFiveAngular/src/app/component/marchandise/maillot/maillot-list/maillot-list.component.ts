import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Marchandise } from 'src/app/model/marchandise';
import { MarchandiseService } from 'src/app/services/marchandise.service';

@Component({
  selector: 'app-maillot-list',
  templateUrl: './maillot-list.component.html',
  styleUrls: ['./maillot-list.component.css']
})
export class MaillotListComponent implements OnInit {
  observableMaillots: Observable<Marchandise[]>;
  message = '';
  showMessage = false;
  constructor(
    private marchandiseService: MarchandiseService,
    private activatedRoute: ActivatedRoute
  ) {
    this.observableMaillots = this.marchandiseService.getAllMaillots();
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
      this.observableMaillots = this.marchandiseService.getAllMaillots();
    });
  }

  addToCart(observableMaillots: any): void {
    this.event.emit(observableMaillots);   
  }
}
