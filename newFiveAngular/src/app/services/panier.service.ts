import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Article } from '../model/article';
import { CartItem } from '../model/cartItem';
import { Marchandise } from '../model/marchandise';

@Injectable({
  providedIn: 'root'
})
export class PanierService {
  
  public cartItemList : Array<CartItem> =[];
  public panierBahaviorSubject = new BehaviorSubject<Array<CartItem>>([]);

  constructor() { }

  getAsObservable(){
    return this.panierBahaviorSubject.asObservable();
  }

  
  addtoCart(article : Article){
  
    let cartItem = this.cartItemList.find((item)=>item.article?.id == article.id);

  if(cartItem){
    cartItem.quantite!++;
    console.log(cartItem.quantite);
  }else{
    this.cartItemList.push(new CartItem(article,1));
  }

  this.panierBahaviorSubject.next(this.cartItemList);  
  //this.getTotalPrice();

  }

  getTotalPrice() : number{
    let grandTotal = 0;
    this.cartItemList.map((a:any)=>{
      grandTotal += a.prix;
    })
    return grandTotal;
  }
  removeCartItem(article: Article){
    let index = this.cartItemList.findIndex(item=>item?.article?.id == article.id);
    
    if(index>=0){
      this.cartItemList.splice(index,1);
    }
      
  

    this.panierBahaviorSubject.next(this.cartItemList);
  }

  
  reduceToCart(article: Article) {
    let cartItem = this.cartItemList.find((item)=>item.article?.id == article.id);

    if(cartItem && cartItem.quantite!>1){
      cartItem.quantite!--;
    }
    this.panierBahaviorSubject.next(this.cartItemList);
  }

  
  removeAllCart(){
    this.cartItemList = []
    this.panierBahaviorSubject.next(this.cartItemList);
  }
}
