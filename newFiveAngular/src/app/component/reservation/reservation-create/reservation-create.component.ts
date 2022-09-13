import { ReservationService } from 'src/app/services/reservation.service';
import { Reservation } from 'src/app/model/reservation';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-reservation-create',
  templateUrl: './reservation-create.component.html',
  styleUrls: ['./reservation-create.component.css']
})
export class ReservationCreateComponent implements OnInit {
  reservation: Reservation;
  httpClient: any;

  constructor(
    private ar: ActivatedRoute,
    private reservationService : ReservationService,
    private router: Router
  ) {
this.reservation=new Reservation();
   }

  ngOnInit(): void {
  }
  annuler(){
    this.router.navigateByUrl('/reservations');
  }
  save() {

    if(true){
      this.reservationService.create(this.reservation).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/reservation/edit/'+result.id);
          //this.router.navigateByUrl('/client?q=create&id='+result.id)
        },
        error: (err) => {
          console.log(err);
        },
      });}
      else{
        alert("Pas de disponibilité")
      }

}
}
