import { HeaderComponent } from './component/header/header.component';
import { NgModule } from '@angular/core';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { ListComponent } from './component/client/client-list/list.component';
import { EditComponent } from './component/client/client-edit/edit.component';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { AdminEditComponent } from './component/admin/admin-edit/admin-edit.component';
import { AdminListComponent } from './component/admin/admin-list/admin-list.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { NewAdminComponent } from './component/admin/new-admin/new-admin.component';
import { ReservationEditComponent } from './component/reservation/reservation-edit/reservation-edit.component';
import { ReservationListComponent } from './component/reservation/reservation-list/reservation-list.component';
import { ReservationCreateComponent } from './component/reservation/reservation-create/reservation-create.component';
import { CarouselComponent } from './component/home/carousel/carousel.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Carousel2Component } from './component/home/carousel2/carousel2.component';
import { FooterComponent } from './component/footer/footer.component';
import { BallonEditComponent } from './component/marchandise/ballon/ballon-edit/ballon-edit.component';
import { BallonListComponent } from './component/marchandise/ballon/ballon-list/ballon-list.component';
import { MaillotEditComponent } from './component/marchandise/maillot/maillot-edit/maillot-edit.component';
import { MaillotListComponent } from './component/marchandise/maillot/maillot-list/maillot-list.component';
import { MarchandiseEditComponent } from './component/marchandise/marchandise-edit/marchandise-edit.component';
import { MarchandiseListComponent } from './component/marchandise/marchandise-list/marchandise-list.component';
import { SingleMaillotComponent } from './component/marchandise/maillot/single-maillot/single-maillot.component';
import { SingleBallonComponent } from './component/marchandise/ballon/single-ballon/single-ballon.component';
import { PanierComponent } from './component/panier/panier.component';
import { TerrainReserveComponent } from './component/terrain-reserve/terrain-reserve.component';
import { CommandeComponent } from './component/commande/commande.component';
import { LoginComponent } from './component/login/login.component';
import { LigneDeCommandeComponent } from './component/ligne-de-commande/ligne-de-commande.component';
import { CommandeDetailsComponent } from './component/commande/commande-details/commande-details.component';

@NgModule({
  declarations: [HeaderComponent, AppComponent, HomeComponent, ListComponent, EditComponent, AdminEditComponent, AdminListComponent, InscriptionComponent, NewAdminComponent, ReservationEditComponent, ReservationListComponent, ReservationCreateComponent, CarouselComponent, Carousel2Component, BallonEditComponent, BallonListComponent,
    MaillotListComponent, MaillotEditComponent, MarchandiseEditComponent,MarchandiseListComponent, FooterComponent, SingleMaillotComponent,SingleBallonComponent, PanierComponent, TerrainReserveComponent, CommandeComponent, LoginComponent, LigneDeCommandeComponent, CommandeDetailsComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule,RouterModule.forRoot(routes), NgbModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
