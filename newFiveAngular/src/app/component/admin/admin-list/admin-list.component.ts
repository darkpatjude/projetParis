import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/services/admin.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css'],
})
export class AdminListComponent implements OnInit {
  observableAdmins: Observable<Admin[]>;
  message = '';
  showMessage = false;
  user: any = undefined;

  constructor(
    private adminService: AdminService,
    private router: Router,
    private authService: AuthService
  ) {
    this.observableAdmins = this.adminService.getAll();
  }

  ngOnInit(): void {
    //this.authService.authentication(this.login, this.password)
    if (this.authService.authenticated) {
      this.user = JSON.parse(sessionStorage.getItem('user')!);
    }
  }

  delete(id: number) {
    this.adminService.deleteById(id).subscribe(() => {
      this.observableAdmins = this.adminService.getAll();
    });
  }

  editAdmin(id: number | undefined): void {
    this.router.navigateByUrl('admin/edit/' + id);
  }
  newAdmin(): void {
    this.router.navigateByUrl('admin/create');
  }
}
