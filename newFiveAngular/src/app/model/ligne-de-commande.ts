import { LigneDeCommandeKey } from "./ligne-de-commande-key";

export class LigneDeCommande {
    constructor(
        private _id?: LigneDeCommandeKey,
        private _quantite?: number
      ) {
       
      }
      public get id(): LigneDeCommandeKey | undefined {
        return this._id;
      }
      public set id(value: LigneDeCommandeKey | undefined) {
        this._id = value;
      }
    
      public get quantite(): number | undefined {
        return this._quantite;
      }
      public set quantite(value: number | undefined) {
        this._quantite = value;
      }
}
