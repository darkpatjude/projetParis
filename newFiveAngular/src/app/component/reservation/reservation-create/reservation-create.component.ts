import { map, Observable, tap } from 'rxjs';
import { TerrainReserveService } from './../../../services/terrain-reserve.service';
import { TerrainReserve } from './../../../model/terrainReserve';
import { ReservationService } from 'src/app/services/reservation.service';
import { Reservation } from 'src/app/model/reservation';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PanierService } from 'src/app/services/panier.service';

@Component({
  selector: 'app-reservation-create',
  templateUrl: './reservation-create.component.html',
  styleUrls: ['./reservation-create.component.css']
})
export class ReservationCreateComponent implements OnInit {
  reservation: Reservation;
  httpClient: any;
  a=0;
  nowDate=new Date();
  public c=new TerrainReserve();


  constructor(
    private ar: ActivatedRoute,
    private reservationService : ReservationService,
    private terrainReserveService:TerrainReserveService,
    private router: Router,
    private panierService: PanierService,
  ) {
this.reservation=new Reservation();
this.reservation.prix=10,
this.reservation.nom="reservation",
this.reservation.terrainReserve=new TerrainReserve;
   }

  ngOnInit(): void {
  }
  annuler(){
    this.router.navigateByUrl('/reservations');
  }
  addToCart(reservation: Reservation) {
    this.panierService.addtoCart(reservation);
   // this.router.navigateByUrl("/panier")
  }

  save() {
    if(true){
    this.terrainReserveService.getById(this.a).subscribe(
      value=>{this.reservation.terrainReserve=value;this.c=value,this.addToCart(this.reservation)
        console.log("depuis le subscribe, nom du terrain : "+this.c.nom)

        this.reservationService.create(this.reservation).subscribe({
          next: (result) => {
            this.router.navigateByUrl('/reservations');
          },
          error: (err) => {
            console.log(err);
          },
        });})
      }else{
        alert("pas de disponibilité")
      }

      }

}
