import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Glasses } from '../models/glasses';
import { Glass } from '../models/glass';

@Injectable({
  providedIn: 'root'
})
export class GlassesService {

  constructor(private http: HttpClient) { }

  products: Glasses[] = [
    {
      id: 1,
      name: 'Ray-Ban Aviator',
      brand: 'Ray-Ban',
      category: 'Aviator',
      shape: 'Oval',
      colour: 'Gold',
      glassesCode: 'RB3025',
      price: 199.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
    {
      id: 2,
      name: 'Ray-Ban Wayfarer',
      brand: 'Ray-Ban',
      category: 'Wayfarer',
      shape: 'Square',
      colour: 'Black',
      glassesCode: 'RB2140',
      price: 149.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
    {
      id: 3,
      name: 'Persol PO0714',
      brand: 'Persol',
      category: 'PO0714',
      shape: 'Round',
      colour: 'Black',
      glassesCode: 'PO0714',
      price: 299.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
    {
      id: 4,
      name: 'Oakley Holbrook',
      brand: 'Oakley',
      category: 'Holbrook',
      shape: 'Square',
      colour: 'Black',
      glassesCode: 'OO9102',
      price: 119.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
    {
      id: 5,
      name: 'Ray-Ban Clubmaster',
      brand: 'Ray-Ban',
      category: 'Clubmaster',
      shape: 'Square',
      colour: 'Tortoise',
      glassesCode: 'RB3016',
      price: 189.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
    {
      id: 6,
      name: 'Tom Ford FT0378',
      brand: 'Tom Ford',
      category: 'FT0378',
      shape: 'Round',
      colour: 'Havana',
      glassesCode: 'FT0378',
      price: 399.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
    {
      id: 7,
      name: 'Persol PO0649',
      brand: 'Persol',
      category: 'PO0649',
      shape: 'Round',
      colour: 'Havana',
      glassesCode: 'PO0649',
      price: 249.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
    {
      id: 8,
      name: 'Maui Jim Peahi',
      brand: 'Maui Jim',
      category: 'Peahi',
      shape: 'Wrap',
      colour: 'Tortoise',
      glassesCode: 'H202-10',
      price: 219.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
    {
      id: 9,
      name: 'Dior Homme Blacktie',
      brand: 'Dior',
      category: 'Blacktie',
      shape: 'Rectangle',
      colour: 'Black',
      glassesCode: '0868S',
      price: 429.99,
      imageURL: 'https://www.kits.ca/cart/images/frames/items/6/61/61000001165_IMG.jpg%22%3E'
    },
  ];

  getAllGlasses(): Observable<Glasses[]> {
    return this.http.get<Glasses[]>('/glasses/all');
  }

  getAllGlassesTest() {
    return this.products;
  }

  getUniqueShapes(): string[] {
    const shapes = ['All'];
    this.products.forEach(product => {
      if (!shapes.includes(product.shape)) {
        shapes.push(product.shape);
      }
    });
    return shapes;
  }

  getUniqueBrands(): string[] {
    const brands = ['All'];
    this.products.forEach(product => {
      if (!brands.includes(product.brand)) {
        brands.push(product.brand);
      }
    });
    return brands;
  }

}
