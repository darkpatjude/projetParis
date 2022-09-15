import { TerrainReserveService } from './../../services/terrain-reserve.service';
import { Observable, tap } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { TerrainReserve } from 'src/app/model/terrainReserve';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-terrain-reserve',
  templateUrl: './terrain-reserve.component.html',
  styleUrls: ['./terrain-reserve.component.css']
})
export class TerrainReserveComponent implements OnInit {
  terrainReserve$!:Observable<TerrainReserve>
  img=["assets/terrain/jaune.jpg","assets/terrain/bleu.jpg","assets/terrain/rouge.jpg","assets/terrain/vert.jpg"]

  constructor(private terrainReserveService: TerrainReserveService,
    private activatedRoute: ActivatedRoute,
    private router:Router) { }

 // this.terrainReserveService.getById(this.a)


  ngOnInit(): void {

    const id=+this.activatedRoute.snapshot.params['id'];
    this.terrainReserve$=this.terrainReserveService.getById(id).pipe(
      tap(value=>value.imageUrl=this.img[id-1]))
  }

}
