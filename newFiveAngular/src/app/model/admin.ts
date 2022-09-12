import { Adresse } from './adresse';

export class Admin {
  constructor(
    private _id?: number,
    private _prenom?: string,
    private _nom?: string,
    private _email?: string,
    private _telephone?: string,
    private _adresse?: Adresse
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

  public get email(): string | undefined {
    return this._email;
  }
  public set email(value: string | undefined) {
    this._email = value;
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

  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
}
