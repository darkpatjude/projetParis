import { Article } from "./article";
import { Ballon } from "./ballon";
import { Maillot } from "./maillot";

export class Marchandise extends Article{
 constructor(
    private _stock?: number,
    private _description?:string,
    private _ballon?:Ballon,
    private _imageUrl?:string,
    private _maillot?:Maillot)

    {
   super();
 }

 public get imageUrl(): string | undefined {
  return this._imageUrl;
}

public set imageUrl(value: string | undefined) {
  this._imageUrl = value;
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

      public get ballon(): Ballon | undefined {
        return this._ballon;
      }
      public set ballon(value: Ballon | undefined) {
        this._ballon = value;
      }

      public get maillot(): Maillot | undefined {
        return this._maillot;
      }
      public set maillot(value: Maillot | undefined) {
        this._maillot = value;
      }

}
