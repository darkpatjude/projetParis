import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Ballon } from 'src/app/model/ballon';
import { BallonService } from 'src/app/services/ballon.service';
import { MarchandiseService } from 'src/app/services/marchandise.service';

@Component({
  selector: 'app-ballon-list',
  templateUrl: './ballon-list.component.html',
  styleUrls: ['./ballon-list.component.css']
})
export class BallonListComponent implements OnInit {
  observableBallons: Observable<Ballon[]>;
  message = '';
  showMessage = false;
  constructor(
    private marchandiseService: MarchandiseService,
    private ballonService: BallonService,
    private activatedRoute: ActivatedRoute
  ) {
    this.observableBallons = this.ballonService.getAllBallons();
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
      this.observableBallons = this.ballonService.getAllBallons();
    });
  }


}
