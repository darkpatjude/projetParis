import { Article } from './article';
import { TerrainReserve } from './terrainReserve';
import { Time } from "@angular/common";

export class Reservation extends Article{
  constructor(


    private _terrainReserve=new TerrainReserve,
    private _date?: Date,
    private _heure?: Time,

  ) {
    super()

  }


  public get terrainReserve(): TerrainReserve {
    return this._terrainReserve;
  }
  public set terrainReserve(value: TerrainReserve) {
    this._terrainReserve = value;
  }

  public set date(value: Date | undefined) {
    this._date= value;
  }
  public get date() {
    return this._date;
  }
  public set heure(value: Time | undefined) {
    this._heure= value;
  }
  public get heure(): Time| undefined {
    return this._heure;
  }

}
