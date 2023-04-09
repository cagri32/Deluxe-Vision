import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.scss']
})
export class MainNavComponent implements OnInit, OnChanges {
  loggedInUser: any;
  user: any

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {
    this.user = this.loginService.getLoggedInUser();
    if (this.user) {
      this.loggedInUser = true;
    }
    this.loginService.userLoggedIn.subscribe(user => {
      this.loggedInUser = true;
      this.user = this.loginService.getLoggedInUser();
    });
  }

  ngOnChanges(): void {
    this.user = this.loginService.getLoggedInUser();
    if (this.user) {
      this.loggedInUser = true;
    }
    this.loginService.userLoggedIn.subscribe(user => {
      this.loggedInUser = true;
      this.user = this.loginService.getLoggedInUser();

    });
  }

  navigateToLoginPage() {
    if (this.loggedInUser) {
      this.router.navigate(['/shop']);
    } else {
      this.router.navigate(['/login']);
    }
  }

  logout(): void {
    this.loginService.logout();
    this.loggedInUser = null;
    this.router.navigate(['/login']);

    // Navigate to the login page
  }


}
