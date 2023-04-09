// shop.component.ts
import { Component } from '@angular/core';
import { CartService } from '../services/cart.service';
import { Glasses } from '../models/glasses';
import { PageEvent } from '@angular/material/paginator';
import { GlassesService } from '../services/glasses.service';

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

  constructor(private cartService: CartService, private glassesService: GlassesService) {}

  ngOnInit(): void {
    // this.products = this.glassesService.getAllGlassesTest();

    this.glassesService.getAllGlasses().subscribe((glasses: Glasses[]) => {
      this.products = glasses;
      this.sortedProducts = this.getSortedProducts();
      this.displayedProducts = this.sortedProducts.slice(0, 6);
    });

    this.categories = this.glassesService.getUniqueShapes();
    this.brands = this.glassesService.getUniqueBrands();

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
    this.cartService.addItemToCart(product);
  }
}
