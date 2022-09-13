import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css']
})
export class ReservationEditComponent implements OnInit {
  reservation: Reservation;
  observableFournisseur: Observable<Reservation[]>;

  constructor(
    private reservationService: ReservationService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.observableFournisseur = this.reservationService.getAll();
    this.reservation = new Reservation();
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
    this.router.navigateByUrl('/clients');}

  save() {
    if (this.reservation.id) {
      this.reservationService.update(this.reservation).subscribe(() => {
       this.router.navigateByUrl('/reservations')
        //this.router.navigateByUrl('/reservation?q=update&id=' + this.reservation.id);
      });
    } else {
      this.reservationService.create(this.reservation).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/reservations')
          //this.router.navigateByUrl('/reservation?q=create&id=' + result.id);
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }
}
