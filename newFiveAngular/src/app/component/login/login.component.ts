import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login = '';
  password = '';
  authError = false;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  submit(form: any) {
    this.authService.authentication(this.login, this.password).subscribe({
      next: (result) => {
        sessionStorage.setItem('token', btoa(this.login + ':' + this.password));
        this.authError = false;
        sessionStorage.setItem('user', JSON.stringify(result));
        this.router.navigateByUrl('/home');
      },
      error: (err) => {
        this.authError = true;
      },
    });
  }
}
