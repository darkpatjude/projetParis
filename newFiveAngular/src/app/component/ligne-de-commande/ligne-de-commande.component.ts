import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Article } from 'src/app/model/article';
import { LigneDeCommandeService } from 'src/app/services/ligne-de-commande.service';

@Component({
  selector: 'app-ligne-de-commande',
  templateUrl: './ligne-de-commande.component.html',
  styleUrls: ['./ligne-de-commande.component.css']
})
export class LigneDeCommandeComponent implements OnInit {
 quantite= 1;
  @Input()
  article :any= [];
  @Output()
  quantiterEvent: EventEmitter<any> = new EventEmitter();

 @Output()

  retirerEvent: EventEmitter<any> = new EventEmitter();
  public grandTotal !: number;
  constructor(private lignedecommandeService : LigneDeCommandeService) { }


  ngOnInit(): void {
    this.lignedecommandeService.getArticles()
    .subscribe(res=>{
      this.article = res;
      this.grandTotal = this.lignedecommandeService.getTotalPrice();
    })
  }

  ajoutQuantiter() {
    this.quantite++;
    this.quantiterEvent.emit({ article: this.article, quantite: this.article.quantite });
  }

  retraitQuantiter() {
    (this.article.quantite>0)?this.article.quantite--:this.article.quantite;
    this.retirerEvent.emit({ article: this.article, quantite: this.article.quantite });
  }

  removeItem(article: Article){
    this.lignedecommandeService.removeCartItem(article);
  }

  emptylignedecommande(){
    this.lignedecommandeService.removeAllCart();
  }
}
