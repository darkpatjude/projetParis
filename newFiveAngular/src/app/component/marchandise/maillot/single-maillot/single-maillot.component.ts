import { MaillotService } from './../../../../services/maillot.service';
import { Observable } from 'rxjs';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Maillot } from 'src/app/model/maillot';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-single-maillot',
  templateUrl: './single-maillot.component.html',
  styleUrls: ['./single-maillot.component.css']
})
export class SingleMaillotComponent implements OnInit {

  maillot$!:Observable<Maillot>
  @Output()
  event = new EventEmitter();
  constructor(
    private maillotService: MaillotService,
              private activatedRoute: ActivatedRoute,
              private router: Router
  ) { }

  ngOnInit(): void {
    const id=+this.activatedRoute.snapshot.params['id'];
    this.maillot$=this.maillotService.getMaillotById(id);
  }
  addToCart(observableMarchandise: any): void {
    this.event.emit(observableMarchandise);
    this.router.navigateByUrl("/panier")
  }

}
