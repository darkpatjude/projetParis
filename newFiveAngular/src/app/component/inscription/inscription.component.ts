import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';
import {  AbstractControl,
  AsyncValidatorFn,   FormControl,
  FormGroup,   ValidationErrors,
  Validators, } from '@angular/forms';
import { InscriptionService } from 'src/app/services/inscription.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  client: Client;

  form: FormGroup;
  password: FormControl;

  constructor(
    private inscriptionService: InscriptionService,
    private router: Router
  ) {
    this.client = new Client();
    this.password = new FormControl('', [
      Validators.required,
      Validators.pattern(
        /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[*?.@!=+#]).{4,20}$/
      ),
    ]);

    this.form = new FormGroup({
      passwordGroup: new FormGroup(
        {
          passwordCtrl: this.password,
          confirmCtrl: new FormControl(''),
        },
        this.equals
      ),
    });
  }

  ngOnInit(): void {

  }
  annuler(){
    this.router.navigateByUrl('/clients');
  }
  save() {


  }
  checkLogin() {

  }

  equals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    return group.get('passwordCtrl')?.value == group.get('confirmCtrl')?.value
      ? null
      : { notequals: true };
  }
}
