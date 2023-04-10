// shop.component.ts
import { Component } from '@angular/core';
import { CartService } from '../services/cart.service';
import { Glasses } from '../models/glasses';
import { PageEvent } from '@angular/material/paginator';
import { GlassesService } from '../services/glasses.service';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent {
  products: Glasses[];
  productsTest: Glasses[];

  categories: string[];
  brands: string[];
  selectedCategory: string = 'All';
  selectedBrand: string = 'All'
  selectedSortOption: string = 'priceDesc';
  sortedProducts: Glasses[];
  displayedProducts: Glasses[];
  cartItems: Glasses[];

  constructor(private cartService: CartService, private glassesService: GlassesService, private router: Router) {}

  ngOnInit(): void {
    // this.products = this.glassesService.getAllGlassesTest();

    this.glassesService.getAllGlasses().subscribe((glasses: Glasses[]) => {
      this.products = glasses;
      this.sortedProducts = this.getSortedProducts();
      this.displayedProducts = this.sortedProducts.slice(0, 6);
      this.categories = this.glassesService.getUniqueShapes(this.products);
      this.brands = this.glassesService.getUniqueBrands(this.products);
    });



    this.selectedSortOption = 'priceAsc';

  }

  getSortedProducts(): Glasses[] {
    if (this.selectedSortOption === 'priceDesc') {
      return this.products.sort((a, b) => b.price - a.price);
    } else {
      return this.products.sort((a, b) => a.price - b.price);
    }
  }

  onSortOptionChanged() {
    this.sortedProducts = this.getSortedProducts();
    this.displayedProducts = this.sortedProducts.slice(0, 6);
  }

  onPageChanged(event: PageEvent) {
    const startIndex = event.pageIndex * event.pageSize;
    const endIndex = startIndex + event.pageSize;
    this.displayedProducts = this.sortedProducts.slice(startIndex, endIndex);
  }

  onCategorySelected(category: string) {
    this.selectedCategory = category;
    if (this.selectedCategory === 'All') {
      this.sortedProducts = this.getSortedProducts();
    } else {
      this.sortedProducts = this.products.filter(product => product.shape === this.selectedCategory);
    }
    this.displayedProducts = this.sortedProducts.slice(0, 6);
  }

  onBrandSelected(category: string) {
    this.selectedBrand = category;
    if (this.selectedBrand === 'All') {
      this.sortedProducts = this.getSortedProducts();
    } else {
      this.sortedProducts = this.products.filter(product => product.brand === this.selectedBrand);
    }
    this.displayedProducts = this.sortedProducts.slice(0, 6);
  }

  addToCart(product: Glasses) {
    const cartItemsFromLocalStorage = localStorage.getItem('cartItems');

    if (cartItemsFromLocalStorage) {
      this.cartItems = JSON.parse(cartItemsFromLocalStorage);
    }
    product.quantity = 1;
    this.cartService.addItemToCart(product, this.cartItems);
    this.cartService.removeDuplicates();
    alert("Added to cart!");
  }

  onTileClicked(event: Event, product: Glasses) {
    // handle tile click event
    this.router.navigate(['/shop/' + product.id ]);
  }
}
