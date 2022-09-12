import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {
  observableReservation: Observable<Reservation[]> | undefined;
  message = '';
  showMessage = false;
reservation: any;


  constructor(
    private reservationService: ReservationService,
    private activatedRoute: ActivatedRoute)
     {    this.observableReservation = this.reservationService.getAll();}

  ngOnInit(): void {   this.showMessage = false;
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `reservation ${params['id']} créé`;
        } else {
          this.message = `reservation ${params['id']} modifié`;
        }
        this.showMessage = true;
      }
    });
  }

  delete(id: number) {
    this.reservationService.deleteById(id).subscribe(() => {
      this.observableReservation = this.reservationService.getAll();
    });
  }

}
