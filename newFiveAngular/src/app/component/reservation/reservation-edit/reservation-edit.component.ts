import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Reservation } from 'src/app/model/reservation';
import { TerrainReserve } from 'src/app/model/terrainReserve';
import { ReservationService } from 'src/app/services/reservation.service';
import { TerrainReserveService } from 'src/app/services/terrain-reserve.service';

@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css']
})
export class ReservationEditComponent implements OnInit {
  reservation: Reservation;
  observableFournisseur: Observable<Reservation[]>;
  a=1;
  b=this.a*2

  constructor(
    private reservationService: ReservationService,
    private activatedRoute: ActivatedRoute,
    private terrainReserveService:TerrainReserveService,
    private router: Router
  ) {
    this.observableFournisseur = this.reservationService.getAll();
    this.reservation = new Reservation();
    this.reservation.terrainReserve=new TerrainReserve;

   }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.reservationService.getById(params['id']).subscribe((result) => {
          this.reservation = result;
        });
      }
    });
  }

  annuler(){
    this.router.navigateByUrl('/reservations');}

  save() {
     this.terrainReserveService.getById(this.a).subscribe(
     value=>{this.reservation.terrainReserve=value,
        console.log("depuis le subscribe, nom du terrain : "+this.reservation.terrainReserve.id)
        })

       // this.reservation.terrainReserve.id=this.a;

    if (this.reservation.id) {
      this.reservationService.update(this.reservation).subscribe(() => {
        this.reservation.terrainReserve.id=this.a;
        console.log("res"+this.a+" "+this.reservation.terrainReserve.id)
       //this.router.navigateByUrl('/reservations')
        //this.router.navigateByUrl('/reservation?q=update&id=' + this.reservation.id);
      });
    } else {
      this.reservationService.create(this.reservation).subscribe({
        next: (result) => {
          //this.router.navigateByUrl('/reservations')
          //this.router.navigateByUrl('/reservation?q=create&id=' + result.id);
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }
}
