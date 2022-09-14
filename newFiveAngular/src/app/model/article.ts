
export class Article {

    constructor(
        private _id?: number,
        private _prix?: number,
        
        private _quantite=1,
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

  public get quantite(): number {
    return this._quantite;
  }
  public set quantite(value: number ) {
    this._quantite=value;
  }
}
