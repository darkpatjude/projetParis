import { Article } from "./article";
import { Commande } from "./commande";

export class LigneDeCommandeKey {
    constructor(
        private _commande?: Commande,
        private _article?: Article
      ) {
       
      }
      public get commande(): Commande | undefined {
        return this._commande;
      }
      public set commande(value: Commande | undefined) {
        this._commande = value;
      }
    
      public get article(): Article | undefined {
        return this._article;
      }
      public set article(value: Article | undefined) {
        this._article = value;
      }
}
