import { InscriptionComponent } from './component/inscription/inscription.component';
import { AdminListComponent } from './component/admin/admin-list/admin-list.component';
import { Routes } from '@angular/router';
import { EditComponent } from './component/client/client-edit/edit.component';
import { ListComponent } from './component/client/client-list/list.component';
import { HomeComponent } from './component/home/home.component';
import { AdminEditComponent } from './component/admin/admin-edit/admin-edit.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'inscription', component: InscriptionComponent},
  { path: 'clients', component: ListComponent },
  { path: 'admins', component: AdminListComponent },
  { path: 'client/edit/:id', component: EditComponent },
  { path: 'admin/edit/:id', component: AdminEditComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
