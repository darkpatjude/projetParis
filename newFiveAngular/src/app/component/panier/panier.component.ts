import { Component,EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Article } from 'src/app/model/article';
import { Panier } from 'src/app/model/panier';
import { PanierService } from 'src/app/services/panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {
  
  @Input()
  article :any= [];
  @Output()
  quantiterEvent: EventEmitter<any> = new EventEmitter();
    
 @Output()

  retirerEvent: EventEmitter<any> = new EventEmitter();
  public grandTotal !: number;
  constructor(private panierService : PanierService) { }
 

  ngOnInit(): void {
    this.panierService.getArticles()
    .subscribe(res=>{
      this.article = res;
      this.grandTotal = this.panierService.getTotalPrice();
    }) 
  }

  ajoutQuantiter() {
    this.article.quantite++;
    this.quantiterEvent.emit({ article: this.article, quantite: this.article.quantite });
  }

  retraitQuantiter() {
    (this.article.quantite>0)?this.article.quantite--:this.article.quantite;
    this.retirerEvent.emit({ article: this.article, quantite: this.article.quantite });
  }
 
  removeItem(article: Article){
    this.panierService.removeCartItem(article);
  }

  emptypanier(){
    this.panierService.removeAllCart();
  } 
}
