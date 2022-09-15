import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Article } from '../model/article';
import { Marchandise } from '../model/marchandise';

@Injectable({
  providedIn: 'root'
})
export class PanierService {
  public cartItemList : any =[]
  public articleList = new BehaviorSubject<any>([]);
  public search = new BehaviorSubject<string>("");
  quantite=0

  constructor() { }
  getArticles(){
    return this.articleList.asObservable();
  }

  setArticle(article : Article){
    this.cartItemList.push(article);
    this.articleList.next(article);
  }
  addtoCart(article : Article){
    this.cartItemList.push(article);
    this.articleList.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList)
  }
  getTotalPrice() : number{
    let grandTotal = 0;
    this.cartItemList.map((a:any)=>{
      grandTotal += a.prix;
    })
    return grandTotal;
  }
  removeCartItem(article: any){
    this.cartItemList.map((a:any, index:any)=>{
      if(article.id=== a.id){
        this.cartItemList.splice(index,1);
      }
    })
    this.articleList.next(this.cartItemList);
  }
  removeAllCart(){
    this.cartItemList = []
    this.articleList.next(this.cartItemList);
  }
}
