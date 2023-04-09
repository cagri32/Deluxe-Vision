import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartItemsSubject = new BehaviorSubject<any[]>([]);
  cartItems$ = this.cartItemsSubject.asObservable();

  constructor() { }

  addItemToCart(item: any): void {
    let cartItems = [...this.cartItemsSubject.value];
    let existingItem = cartItems.find(i => i.name === item.name);

    if (existingItem) {
      existingItem.quantity++;
    } else {
      cartItems.push({...item, quantity: 1});
    }

    this.cartItemsSubject.next(cartItems);
  }

  removeItemFromCart(item: any): void {
    let cartItems = [...this.cartItemsSubject.value];
    let existingItem = cartItems.find(i => i.name === item.name);

    if (existingItem) {
      existingItem.quantity--;

      if (existingItem.quantity === 0) {
        cartItems = cartItems.filter(i => i.name !== item.name);
      }

      this.cartItemsSubject.next(cartItems);
    }
  }

  clearCart(): void {
    this.cartItemsSubject.next([]);
  }
}
