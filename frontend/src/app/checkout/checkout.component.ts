import { Component, OnInit, TemplateRef } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { CartService } from '../services/cart.service';
import { Glasses } from '../models/glasses';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {
  cartItems: Glasses[] = [];
  user: any;
  loggedInUser: any;
  flag: boolean;
  totalPrice: number = 0;
  finalPrice: number = 0;
  cardForm: FormGroup;

  cardNumberFormControl = new FormControl('', [
    Validators.required,
    Validators.maxLength(16),
    Validators.pattern(/^\d{16}$/)
  ]);

  expirationDateFormControl = new FormControl('', [
    Validators.required,
    Validators.maxLength(5),
    Validators.pattern(/^(0[1-9]|1[0-2])\/\d{2}$/),
    this.expirationDateValidator.bind(this)
  ]);

  securityCodeFormControl = new FormControl('', [
    Validators.required,
    Validators.maxLength(3),
    Validators.pattern(/^\d{3}$/)
  ]);



  constructor(private router: Router, private loginService: LoginService, private cartService: CartService) {
    this.cardForm = new FormGroup({
      'cardNumber': new FormControl('', [Validators.required, Validators.minLength(16), Validators.maxLength(16)]),
      'expirationDate': new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(5)]),
      'securityCode': new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(3)])
    });
  }


  ngOnInit(): void {
    this.loggedInUser = false;

    this.flag = false;
    this.getCartItems();

    this.getPrice();
    this.user = this.loginService.getLoggedInUser();
    if (this.user) {
      this.loggedInUser = true;
    }
    this.loginService.userLoggedIn.subscribe(user => {
      this.loggedInUser = true;
      this.user = this.loginService.getLoggedInUser();
    });

  }

  expirationDateValidator(control: any) {
    const [month, year] = control.value.split('/');
    const inputDate = new Date(Number('20' + year), Number(month) - 1, 1);
    const today = new Date();
    if (inputDate < today) {
      return { expiredDate: true };
    }
    return null;
  }

  checkout() {
    this.cartService.clearCart();

  }

  onTileClicked(event: Event, product: Glasses) {
    // handle tile click event
    this.router.navigate(['/shop/' + product.id]);
  }

  getCartItems() {
    const cartItemsFromLocalStorage = localStorage.getItem('cartItems');

    if (cartItemsFromLocalStorage) {
      this.cartItems = JSON.parse(cartItemsFromLocalStorage);
    }
  }

  getPrice() {
    this.cartItems.forEach(item => {
      this.totalPrice = item.price * item.quantity + this.totalPrice;
    })

    this.finalPrice = this.totalPrice * 1.13;

  }

  getUpdatedPrice() {
    this.totalPrice = 0;
    this.cartItems.forEach(item => {
      this.totalPrice = item.price * item.quantity + this.totalPrice;
    })

    this.finalPrice = this.totalPrice * 1.13;
  }

  removeItem(item: Glasses) {
    this.getCartItems();
    this.cartService.removeItemFromCart(item, this.cartItems);
    this.totalPrice = this.totalPrice - item.price;
    this.getUpdatedPrice();

  }

  addToCart(item: Glasses) {
    this.getCartItems();
    item.quantity = 1;
    this.cartService.addItemToCart(item, this.cartItems);
    this.cartService.removeDuplicates();
    this.getCartItems();
    this.getUpdatedPrice();


  }
}
