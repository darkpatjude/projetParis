import { Article } from "./article";
import { Ballon } from "./ballon";
import { Maillot } from "./maillot";

export class Marchandise extends Article{
 constructor( private _nom?: string,
    private _stock?: number,
    private _description?:string,
    private _ballon?:Ballon,
    private _maillot?:Maillot)
    
    {
   super();
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
