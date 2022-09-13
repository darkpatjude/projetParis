import { Time } from "@angular/common";

export class TerrainReserve {

  constructor(
  private _id?: number,
  private _nom?: string,
  private _heureFermeture?: Time,
  private _heureOuverture?:Time,

) {}

public get id(): number | undefined {
  return this._id;
}

public set id(value: number | undefined) {
  this._id = value;
}

public get nom(): string | undefined {
  return this._nom;
}

public set nom(value: string | undefined) {
    this._nom = value;
  }

public set heureFermeture(value: Date | undefined) {
  this.heureFermeture= value;
}

public set heureOuverture(value: Date | undefined){
  this.heureOuverture;
 }
}


