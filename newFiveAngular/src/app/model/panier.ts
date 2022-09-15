import { Article } from "./article";

export class Panier {
    constructor(
        private _article?: Article,
        private _quantite?: number
      ) {
       
      }
      public get article(): Article | undefined {
        return this._article;
      }
      public set article(value: Article | undefined) {
        this._article = value;
      }
    
      public get quantite(): number | undefined {
        return this._quantite;
      }
      public set quantite(value: number | undefined) {
        this._quantite = value;
      }
}
