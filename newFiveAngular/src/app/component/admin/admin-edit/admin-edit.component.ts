import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/model/admin';
import { Adresse } from 'src/app/model/adresse';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-edit',
  templateUrl: './admin-edit.component.html',
  styleUrls: ['./admin-edit.component.css']
})
export class AdminEditComponent implements OnInit {

  admin: Admin;
  adresse: Adresse;

  constructor(
    private ar: ActivatedRoute,
    private adminService: AdminService,
    private router: Router
  ) {
    this.admin = new Admin();
    this.adresse=new Adresse();
  }

  ngOnInit(): void {
    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.adminService.getById(params['id']).subscribe((result) => {
          this.admin = result;
          if(result.adresse){
          this.adresse=result.adresse;}
        });
      }
    });
  }
  annuler(){
    this.router.navigateByUrl('/admins');
  }
  save() {
    this.admin.adresse=this.adresse;
    if (this.admin.id) {
      this.adminService.update(this.admin).subscribe(() => {
        //this.router.navigateByUrl('/admin?q=update&id=' + this.admin.id);
        this.router.navigateByUrl('/admins');
      });
    } else {
      this.adminService.create(this.admin).subscribe({
        next: (result) => {
          //this.router.navigateByUrl('/admin?q=create&id=' + result.id);
          this.router.navigateByUrl('/admins');
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }

}
