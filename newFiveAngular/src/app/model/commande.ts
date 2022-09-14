import { Client } from "./client";
import { LigneDeCommande } from "./ligne-de-commande";

export class Commande {

   constructor( private _id?: number,
    private _date?: Date,
    private _prix?:number,
    private _client?:Client,
    private _ligne?:LigneDeCommande
  ) {
   
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  public get prix(): number | undefined {
    return this._prix;
  }
  public set prix(value: number | undefined) {
    this._prix = value;
  }

  public get date(): Date | undefined {
    return this._date;
  }
  public set date(value: Date | undefined) {
    this._date = value;
  }
  public get ligne(): LigneDeCommande | undefined {
    return this._ligne;
  }
  public set ligne(value: LigneDeCommande | undefined) {
    this._ligne = value;
  }

  public get client(): Client | undefined {
    return this._client;
  }
  public set client(value: Client | undefined) {
    this._client = value;
  }
}
