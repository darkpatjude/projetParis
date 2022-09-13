import { TerrainReserve } from './terrainReserve';
import { Time } from "@angular/common";

export class Reservation {
  constructor(
    private _id?: number,
    private _prix?: number,
    private _terrainReserve?:TerrainReserve,
    private _date?: Date,
    private _heure?: Time,
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get terrainReserve(): TerrainReserve | undefined {
    return this._terrainReserve;
  }
  public set terrainReserve(value: TerrainReserve | undefined) {
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

  public set prix(value: number | undefined) {
    this._prix = value;
  }
  public get prix(): number | undefined {
    return this._prix;
  }
}
