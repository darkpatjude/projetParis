import { Component,EventEmitter, Input, OnInit, Output } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Article } from 'src/app/model/article';
import { CartItem } from 'src/app/model/cartItem';
import { PanierService } from 'src/app/services/panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  cartItems :Array<CartItem>= [];

  @Output()
  quantiterEvent: EventEmitter<any> = new EventEmitter();
  retirerEvent: EventEmitter<any> = new EventEmitter();


  public grandTotal !: number;
  constructor(private panierService : PanierService) { }


  ngOnInit(): void {
    this.panierService.getAsObservable()
    .subscribe(res=>{
      this.cartItems = res;
      this.calculateTotal();
    })
  }

  calculateTotal(): void {
    this.grandTotal = 0;
    this.cartItems.forEach((cartItem)=>{
        let quantite = cartItem.quantite || 0;
        let prix = cartItem.article?.prix || 0;
        this.grandTotal += (prix * quantite);
    });


  }

  ajoutQuantiter(article: Article) {
    this.panierService.addtoCart(article);
  }

  retraitQuantiter(article: Article) {
    this.panierService.reduceToCart(article);
  }

  removeItem(article: Article){
    this.panierService.removeCartItem(article);
  }

  emptypanier(){
    this.panierService.removeAllCart();
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////
}
