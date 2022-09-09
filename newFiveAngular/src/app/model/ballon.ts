export class Ballon {
  constructor(
    private _id?: number,
    private _prix?: number,
    private _description?: string,
    private _nom?: string,
    private _stock?: number,
    private _equipe?: string,
    private _couleur?: string
  ) {}

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
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get description(): string | undefined {
    return this._description;
  }
  public set description(value: string | undefined) {
    this._description = value;
  }

  public get stock(): number | undefined {
    return this._stock;
  }
  public set stock(value: number | undefined) {
    this._stock = value;
  }

  public get equipe(): string | undefined {
    return this._equipe;
  }
  public set equipe(value: string | undefined) {
    this._equipe = value;
  }

  public get couleur(): string | undefined {
    return this._couleur;
  }
  public set couleur(value: string | undefined) {
    this._couleur = value;
  }
}
