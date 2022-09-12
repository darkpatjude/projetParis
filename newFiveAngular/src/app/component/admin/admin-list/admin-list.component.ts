import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {

  observableAdmins: Observable<Admin[]>;
  message = '';
  showMessage = false;

  constructor(private adminService: AdminService, private router:Router) {
    this.observableAdmins = this.adminService.getAll();
  }

  ngOnInit(): void {}



  editAdmin(id:number|undefined):void{
    this.router.navigateByUrl("admin/edit/"+id)
}

}
