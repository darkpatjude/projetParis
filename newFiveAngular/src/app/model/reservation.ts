import { Time } from "@angular/common";

export class Reservation {

  constructor(
    private _id?: number,
    private _prix?: number,
    private _terrain?:string,
    private _date?: Date,
    private _heure?: Time,
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get terrain(): string | undefined {
    return this._terrain;
  }

  public set terrain(value: string | undefined) {
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
