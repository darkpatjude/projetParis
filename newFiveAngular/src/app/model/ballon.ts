import { Marchandise } from "./marchandise";

export class Ballon extends Marchandise{
    constructor(
      private _taille?: string,
      private _couleur?: string
    ) { super()
    }
  
    public get taille(): string | undefined {
      return this._taille;
    }
    public set taille(value: string | undefined) {
      this._taille = value;
    }
  
    public get couleur(): string | undefined {
      return this._couleur;
    }
    public set couleur(value: string | undefined) {
      this._couleur = value;
    }
  }
  