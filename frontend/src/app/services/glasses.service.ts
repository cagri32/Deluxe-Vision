import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Glasses } from '../models/glasses';
import { Glass } from '../models/glass';

export const BASE_URI: string = "http://localhost:8080"

@Injectable({
  providedIn: 'root'
})
export class GlassesService {

  constructor(private http: HttpClient) { }

  products: Glasses[];

  getAllGlasses(): Observable<Glasses[]> {
    return this.http.get<Glasses[]>(BASE_URI +'/glasses/all');
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
