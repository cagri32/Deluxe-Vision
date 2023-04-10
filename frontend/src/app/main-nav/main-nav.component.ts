import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.scss']
})
export class MainNavComponent implements OnInit, OnChanges {
  loggedInUser: any;
  user: any
  cartItemCount: number;

  constructor(private router: Router, private loginService: LoginService, private cartService: CartService) { }

  ngOnInit(): void {
    const cartItems = localStorage.getItem('cartCount');
    if (cartItems) {
      this.cartItemCount = JSON.parse(cartItems);
    }
    this.user = this.loginService.getLoggedInUser();
    if (this.user) {
      this.loggedInUser = true;
    }
    this.loginService.userLoggedIn.subscribe(user => {
      this.loggedInUser = true;
      this.user = this.loginService.getLoggedInUser();
    });

    this.cartService.countChanged.subscribe({
      next: (response: any) => {
        this.cartItemCount = response;
      }
    })
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
    this.clearCart();
    // Navigate to the login page
  }

  clearCart() {
    this.cartService.clearCart();
  }

}
