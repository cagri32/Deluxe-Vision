import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GlassesService } from '../services/glasses.service';
import { Glasses } from '../models/glasses';
import { CartService } from '../services/cart.service';
import { Glass } from '../models/glass';
import { MatDialog } from '@angular/material/dialog';
import { ReviewDialogComponent } from '../reviewDialog/review-dialog/review-dialog.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  productId: number;
  glasses: Glasses;
  glassInfo: Glass[];
  cartItems: Glasses[];

  constructor(private route: ActivatedRoute, private glassesService: GlassesService, private cartService: CartService, public dialog: MatDialog) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.productId = params['id'];
      // fetch product data using productId
      this.glassesService.getGlassesWithID(this.productId).subscribe({
        next: (response) => {
          this.glasses = response;
        }
      })
      this.glassesService.getGlassesReviewId(this.productId).subscribe({
        next: (response) => {
          this.glassInfo = response;
        }
      })

    });



    // this.glassesService.getGlassesReview().subscribe({
    //   next: (response: Glass) => {
    //     this.glassInfo = response;
    //   }
    // })


  }

  getCartItems() {
    const cartItemsFromLocalStorage = localStorage.getItem('cartItems');

    if (cartItemsFromLocalStorage) {
      this.cartItems = JSON.parse(cartItemsFromLocalStorage);
    }
  }

  addToCart() {
    this.getCartItems();
    this.glasses.quantity = 1;
    this.cartService.addItemToCart(this.glasses, this.cartItems);
    this.cartService.removeDuplicates();
    alert("Added to cart!");
  }

  review() {
    const dialogRef = this.dialog.open(ReviewDialogComponent, {
      width: '400px',
      height: '400px',
      data: { productId: this.productId }
    });
  }
}
