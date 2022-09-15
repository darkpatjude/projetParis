import { BallonService } from './../../../services/ballon.service';
import { TerrainReserveService } from './../../../services/terrain-reserve.service';
import { TerrainReserve } from 'src/app/model/terrainReserve';
import { map, Observable, tap } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-terrain-list',
  templateUrl: './terrain-list.component.html',
  styleUrls: ['./terrain-list.component.css']
})
export class TerrainListComponent implements OnInit {
  listTerrain$:Observable<TerrainReserve[]>
  img=["assets/terrain/jaune.jpg","assets/terrain/bleu.jpg","assets/terrain/rouge.jpg","assets/terrain/vert.jpg"]
  constructor(
    private terrainReserveService:TerrainReserveService,
    private bService:BallonService
  ) {
    this.listTerrain$=this.terrainReserveService.getAll().pipe(
      tap(terrains=>{
      for( let a of terrains){
        if(a.id){
          a.imageUrl=this.img[a.id-1]
          }

      } return terrains
    }
      ));
   }

  ngOnInit(): void {

}
}
