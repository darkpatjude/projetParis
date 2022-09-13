import { Marchandise } from "./marchandise";

export class Maillot extends Marchandise{
    constructor(
      private _equipe?: string,
      private _taille?: string
    ) {
      super()
     
    }
    public get equipe(): string | undefined {
      return this._equipe;
    }
    public set equipe(value: string | undefined) {
      this._equipe = value;
    }
  
    public get taile(): string | undefined {
      return this._taille;
    }
    public set taille(value: string | undefined) {
      this._taille = value;
    }
  }