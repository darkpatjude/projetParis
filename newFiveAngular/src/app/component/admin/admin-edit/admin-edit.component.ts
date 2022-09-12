import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-edit',
  templateUrl: './admin-edit.component.html',
  styleUrls: ['./admin-edit.component.css']
})
export class AdminEditComponent implements OnInit {

  admin: Admin;

  constructor(
    private ar: ActivatedRoute,
    private adminService: AdminService,
    private router: Router
  ) {
    this.admin = new Admin();
  }

  ngOnInit(): void {
    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.adminService.getById(params['id']).subscribe((result) => {
          this.admin = result;
        });
      }
    });
  }
  annuler(){
    this.router.navigateByUrl('/admins');
  }
  save() {
    if (this.admin.id_admin) {
      this.adminService.update(this.admin).subscribe(() => {
        this.router.navigateByUrl('/admin?q=update&id=' + this.admin.id_admin);
      });
    } else {
      this.adminService.create(this.admin).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/admin?q=create&id=' + result.id_admin);
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }

}
