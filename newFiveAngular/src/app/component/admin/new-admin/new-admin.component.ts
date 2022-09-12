import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-new-admin',
  templateUrl: './new-admin.component.html',
  styleUrls: ['./new-admin.component.css']
})
export class NewAdminComponent implements OnInit {

  admin:Admin;
  mdp !: string;
  mdpConf!:string;
  httpAdmin: any;
  constructor(
    private ar: ActivatedRoute,
    private adminService: AdminService,
    private router: Router
  ) {
    this.admin = new Admin();
  }

  ngOnInit(): void {

  }
  annuler(){
    this.router.navigateByUrl('/admins');
  }
  save() {

    if(this.mdp===this.mdpConf){
      this.adminService.create(this.admin).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/admin/edit/'+result.id);
          //this.router.navigateByUrl('/admin?q=create&id='+result.id)
        },
        error: (err) => {
          console.log(err);
        },
      });}
      else{
        alert("mot de passe non conforme")
      }

}

}
