import { Time } from "@angular/common";
import { Terrain } from "./terrain";

export class Reservation {

  constructor(
    private _id?: number,
    private _prix?: number,
    private _terrain?:Terrain,
    private _date?: Date,
    private _heure?: Time,
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get terrain(): Terrain| undefined {
    return this._terrain;
  }

  public set terrain(value: Terrain | undefined) {
      this._terrain = value;
    }

  public set date(value: Date | undefined) {
    this._date= value;
  }

  public set heure(value: Date | undefined){
   this._heure;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }
  public get prix(): number | undefined {
    return this._prix;
  }
}
