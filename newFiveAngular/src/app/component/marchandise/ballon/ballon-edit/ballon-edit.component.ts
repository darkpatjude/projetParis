import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ballon } from 'src/app/model/ballon';
import { MarchandiseService } from 'src/app/services/marchandise.service';

@Component({
  selector: 'app-ballon-edit',
  templateUrl: './ballon-edit.component.html',
  styleUrls: ['./ballon-edit.component.css']
})
export class BallonEditComponent implements OnInit {

  ballon: Ballon;
  
  // @Output()
  // ballonEvent: EventEmitter<any> = new EventEmitter();

  constructor(private ar: ActivatedRoute, private marchandiseService: MarchandiseService, private router: Router) {
    this.ballon = new Ballon();
    console.log(this.ballon);
  }

  ngOnInit(): void {
    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.marchandiseService.getBallonById(params['id']).subscribe((result) => {
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
      this.marchandiseService.update(this.ballon).subscribe(() => {
        this.router.navigateByUrl('/marchandise' );
      });
    } else {
      this.marchandiseService.createBallon(this.ballon).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/marchandise');
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }

 

}
