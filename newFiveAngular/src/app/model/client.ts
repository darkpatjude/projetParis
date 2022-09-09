import { Adresse } from './adresse';

export class Client {
  constructor(
    private _prenom?: string,
    private _nom?: string,
    private _mail?: string,
    private _telephone?: string,
    private _adresse?: Adresse,
    private _id_client?: number
  ) {}
  public get prenom(): string | undefined {
    return this._prenom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get mail(): string | undefined {
    return this._mail;
  }
  public set mail(value: string | undefined) {
    this._mail = value;
  }

  public get telephone(): string | undefined {
    return this._telephone;
  }
  public set telephone(value: string | undefined) {
    this._telephone = value;
  }

  public get adresse(): Adresse | undefined {
    return this._adresse;
  }
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  public get id_client(): number | undefined {
    return this._id_client;
  }
  public set id_client(value: number | undefined) {
    this._id_client = value;
  }
}
