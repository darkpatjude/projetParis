import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ballon } from 'src/app/model/ballon';
import { BallonService } from 'src/app/services/ballon.service';

@Component({
  selector: 'app-ballon-edit',
  templateUrl: './ballon-edit.component.html',
  styleUrls: ['./ballon-edit.component.css']
})
export class BallonEditComponent implements OnInit {

  ballon: Ballon;

  // @Output()
  // ballonEvent: EventEmitter<any> = new EventEmitter();

  constructor(private ar: ActivatedRoute, private ballonService: BallonService, private router: Router) {
    this.ballon = new Ballon();
    console.log(this.ballon);
  }

  ngOnInit(): void {
    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.ballonService.getBallonById(params['id']).subscribe((result) => {
          console.log(result);
          this.ballon = result;
        });
      }
    });
  }

  // send() {
  //   this.ballonEvent.emit({ nom: this.ballon.nom, prix: this.ballon.prix , taille: this.ballon.taille, equipe:this.ballon.equipe});
  // }

  save() {
    console.log(this.ballon);
    if (this.ballon.id) {
      this.ballonService.updateBallon(this.ballon).subscribe(() => {
        this.router.navigateByUrl('/marchandise/ballon');
      });
    } else {
      this.ballonService.createBallon(this.ballon).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/marchandise/ballon');
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }


}
