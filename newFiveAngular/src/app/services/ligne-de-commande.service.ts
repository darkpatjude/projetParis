import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Article } from '../model/article';
import { Commande } from '../model/commande';
import { CommandeService } from './commande.service';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root'
})
export class LigneDeCommandeService {

  public cartItemList : any =[]
  public articleList = new BehaviorSubject<any>([]);
  public search = new BehaviorSubject<string>("");

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
  removeCartItem(article: Article){
    this.cartItemList.map((a:Article, index:any)=>{
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
