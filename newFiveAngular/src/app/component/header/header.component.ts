import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {}

  logout() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
    window.location.reload();
  }

  get logged(): boolean {
    return this.authService.authenticated;
  }
}
