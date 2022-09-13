import { HeaderComponent } from './component/header/header.component';
import { NgModule } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
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

@NgModule({
  declarations: [HeaderComponent, AppComponent, HomeComponent, ListComponent, EditComponent, AdminEditComponent, AdminListComponent, InscriptionComponent, NewAdminComponent, ReservationEditComponent, ReservationListComponent, ReservationCreateComponent, CarouselComponent, Carousel2Component, FooterComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule,RouterModule.forRoot(routes), NgbModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
