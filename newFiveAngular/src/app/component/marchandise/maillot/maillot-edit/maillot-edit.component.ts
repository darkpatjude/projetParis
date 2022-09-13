import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Maillot } from 'src/app/model/maillot';
import { MaillotService } from 'src/app/services/maillot.service';

@Component({
  selector: 'app-maillot-edit',
  templateUrl: './maillot-edit.component.html',
  styleUrls: ['./maillot-edit.component.css']
})
export class MaillotEditComponent implements OnInit {

  maillot: Maillot;
  
  // @Output()
  // maillotEvent: EventEmitter<any> = new EventEmitter();

  constructor(private ar: ActivatedRoute, private maillotService: MaillotService,private router: Router) {
    this.maillot = new Maillot();
    console.log(this.maillot);
  }

  ngOnInit(): void {
    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.maillotService.getMaillotById(params['id']).subscribe((result) => {
          console.log(result);
          this.maillot = result;
        });
      }
    });
  }

  // send() {
  //   this.maillotEvent.emit({ nom: this.maillot.nom, prix: this.maillot.prix , taille: this.maillot.taille, equipe:this.maillot.equipe});
  // }

  save() {
    console.log(this.maillot);
    if (this.maillot.id) {
      this.maillotService.updateMaillot(this.maillot).subscribe(() => {
        this.router.navigateByUrl('/marchandise/maillot' );
      });
    } else {
      this.maillotService.createMaillot(this.maillot).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/marchandise/maillot');
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }

 

}
