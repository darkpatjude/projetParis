import { TerrainListComponent } from './component/terrain-reserve/terrain-list/terrain-list.component';
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
import { PanierComponent } from './component/panier/panier.component';
import { LigneDeCommandeComponent } from './component/ligne-de-commande/ligne-de-commande.component';
import { CommandeComponent } from './component/commande/commande.component';
import { TerrainReserveComponent } from './component/terrain-reserve/terrain-reserve.component';
import { SingleMaillotComponent } from './component/marchandise/maillot/single-maillot/single-maillot.component';
import { SingleBallonComponent } from './component/marchandise/ballon/single-ballon/single-ballon.component';
import { AuthGuardService } from './services/auth-guard.service';

export const routes: Routes = [
  { path: 'terrains', component: TerrainListComponent },
  { path: 'home', component: HomeComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'clients', component: ListComponent ,
  canActivate: [AuthGuardService] },
  { path: 'admins', component: AdminListComponent ,
  canActivate: [AuthGuardService] },
  { path: 'reservations', component: ReservationListComponent ,
  canActivate: [AuthGuardService]},
  { path: 'reservation/create', component: ReservationCreateComponent},
  { path: 'client/edit/:id', component: EditComponent ,
  canActivate: [AuthGuardService]},
  { path: 'admin/edit/:id', component: AdminEditComponent ,
  canActivate: [AuthGuardService]},
  { path: 'reservation/edit/:id', component: ReservationEditComponent ,
  canActivate: [AuthGuardService]},
  { path: 'admin/create', component: NewAdminComponent ,
  canActivate: [AuthGuardService]},
  { path: 'marchandise', component: MarchandiseListComponent },
  { path: 'panier', component: PanierComponent},
  { path: 'lignedecommande', component: LigneDeCommandeComponent ,
  canActivate: [AuthGuardService]},
  { path: 'commande', component: CommandeComponent ,
  canActivate: [AuthGuardService]},
  { path: 'marchandise/edit/:id', component: MarchandiseListComponent ,
  canActivate: [AuthGuardService]},
  { path: 'marchandise/ballon/add', component: BallonEditComponent ,
  canActivate: [AuthGuardService]},
  { path: 'marchandise/ballon', component: BallonListComponent ,
  canActivate: [AuthGuardService] },
  { path: 'marchandise/maillot', component: MaillotListComponent ,
  canActivate: [AuthGuardService] },
  { path: 'marchandise/maillot/edit/:id', component: MaillotEditComponent ,
  canActivate: [AuthGuardService]},
  { path: 'marchandise/ballon/edit/:id', component: BallonEditComponent ,
  canActivate: [AuthGuardService] },
  { path: 'marchandise/maillot/add', component: MaillotEditComponent ,
  canActivate: [AuthGuardService] },
  { path: 'terrain/:id', component: TerrainReserveComponent },
  { path: 'marchandise/maillot/:id', component: SingleMaillotComponent },
  { path: 'marchandise/ballon/:id', component: SingleBallonComponent },

  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
