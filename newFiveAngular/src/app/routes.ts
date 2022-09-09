import { Routes } from "@angular/router";
import { EditComponent } from "./component/client/edit/edit.component";
import { ListComponent } from "./component/client/list/list.component";
import { HomeComponent } from "./component/home/home.component";

export const routes: Routes = [
    { path: 'home', component: HomeComponent},
    { path: 'client', component: ListComponent },
    { path: 'client/edit/:id', component: EditComponent },
    { path: '', redirectTo: '/home', pathMatch: 'full' },
  ];