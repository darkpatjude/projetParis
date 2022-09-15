import { ActivatedRoute, Router } from '@angular/router';
import { BallonService } from './../../../../services/ballon.service';
import { Observable } from 'rxjs';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Ballon } from 'src/app/model/ballon';

@Component({
  selector: 'app-single-ballon',
  templateUrl: './single-ballon.component.html',
  styleUrls: ['./single-ballon.component.css']
})
export class SingleBallonComponent implements OnInit {

  ballon$!:Observable<Ballon>
  @Output()
  event = new EventEmitter();

  constructor(private ballonService: BallonService,
              private activatedRoute: ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    const id=+this.activatedRoute.snapshot.params['id'];
    this.ballon$=this.ballonService.getBallonById(id);
  }
  addToCart(observableMarchandise: any): void {
    this.event.emit(observableMarchandise);
    this.router.navigateByUrl("/panier")
  }
}
