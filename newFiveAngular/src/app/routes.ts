import { CarouselComponent } from './component/home/carousel/carousel.component';
import { ReservationCreateComponent } from './component/reservation/reservation-create/reservation-create.component';
import { ReservationListComponent } from './component/reservation/reservation-list/reservation-list.component';
import { ReservationEditComponent } from './component/reservation/reservation-edit/reservation-edit.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { AdminListComponent } from './component/admin/admin-list/admin-list.component';
import { Routes } from '@angular/router';
import { EditComponent } from './component/client/client-edit/edit.component';
import { ListComponent } from './component/client/client-list/list.component';
import { HomeComponent } from './component/home/home.component';
import { AdminEditComponent } from './component/admin/admin-edit/admin-edit.component';
import { NewAdminComponent } from './component/admin/new-admin/new-admin.component';
import { MarchandiseListComponent } from './component/marchandise/marchandise-list/marchandise-list.component';
import { BallonEditComponent } from './component/marchandise/ballon/ballon-edit/ballon-edit.component';
import { BallonListComponent } from './component/marchandise/ballon/ballon-list/ballon-list.component';
import { MaillotListComponent } from './component/marchandise/maillot/maillot-list/maillot-list.component';
import { MaillotEditComponent } from './component/marchandise/maillot/maillot-edit/maillot-edit.component';
import { LoginComponent } from './component/login/login.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'inscription', component: InscriptionComponent},
  { path: 'clients', component: ListComponent },
  { path: 'admins', component: AdminListComponent },
  { path: 'reservations', component: ReservationListComponent },
  { path: 'reservation/create', component: ReservationCreateComponent },
  { path: 'client/edit/:id', component: EditComponent },
  { path: 'admin/edit/:id', component: AdminEditComponent },
  { path: 'reservation/edit/:id', component: ReservationEditComponent },
  { path: 'admin/create', component: NewAdminComponent },
  { path: 'marchandise', component: MarchandiseListComponent},

  { path: 'marchandise/edit/:id', component: MarchandiseListComponent},
    { path: 'marchandise/ballon/add', component: BallonEditComponent},
    { path: 'marchandise/ballon', component: BallonListComponent},
    { path: 'marchandise/maillot', component: MaillotListComponent},
    { path: 'marchandise/maillot/edit/:id', component: MaillotEditComponent},
    { path: 'marchandise/ballon/edit/:id', component: BallonEditComponent},
    { path: 'marchandise/maillot/add', component: MaillotEditComponent},
    { path: 'login', component: LoginComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },

];
