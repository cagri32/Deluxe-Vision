import { EventEmitter, Injectable } from '@angular/core';
import { Glasses } from '../models/glasses';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: Glasses[] = [];
  cartItemCount: number = 0;
  countChanged: EventEmitter<number> = new EventEmitter();
  constructor() { }

  addItemToCart(item: Glasses, cart: Glasses[]): void {
    this.cartItems = cart;
    this.cartItems.push(item);
    this.cartItemCount++;
    localStorage.setItem('cartCount', this.cartItemCount.toString());
    localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
    this.countChanged.emit(this.cartItemCount);

  }

  getCartItems(): Glasses[] {
    return this.cartItems;
  }

  clearCart(): void {
    this.cartItems = [];
    this.cartItemCount = 0;
    localStorage.setItem('cartCount', this.cartItemCount.toString());
    localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
    this.countChanged.emit(this.cartItemCount);

  }

  removeItemFromCart(item: Glasses, cart: Glasses[]): void {
    this.cartItems = cart;
    const index = cart.findIndex((i) => i.id === item.id);
    if (index > -1) {
      const cartItem = cart[index];
      if (cartItem.quantity && cartItem.quantity > 0) {
        cartItem.quantity -= 1;
        if (cartItem.quantity <= 0) {
          cart.splice(index, 1);
        }
        this.cartItemCount--;
        localStorage.setItem('cartCount', this.cartItemCount.toString());
        localStorage.setItem('cartItems', JSON.stringify(cart));
        this.countChanged.emit(this.cartItemCount);
      }
    }
  }
  

  getIDs(): number[] {
    return this.cartItems.map(item => item.id);
  }


  removeDuplicates() {
    const cartItemsFromLocalStorage = localStorage.getItem('cartItems');
    if (cartItemsFromLocalStorage) {

      const seenItems: { [id: number]: boolean } = {};
      const dedupedItems: Glasses[] = [];

      this.cartItems.forEach((item) => {
        const id = item.id;
        if (seenItems[id]) {
          // increment quantity of existing item
          const existingItem = dedupedItems.find((i) => i.id === id);
          if (existingItem) {
            existingItem.quantity += 1;
          }
        } else {
          seenItems[id] = true;
          dedupedItems.push(item);
        }
      });

      // Save the deduped items back to localStorage
      localStorage.setItem('cartItems', JSON.stringify(dedupedItems));
    }
  }

}
