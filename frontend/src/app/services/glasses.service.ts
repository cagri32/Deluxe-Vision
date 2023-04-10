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


  getAllGlasses(): Observable<Glasses[]> {
    return this.http.get<Glasses[]>(BASE_URI + '/glasses/all');
  }

  getGlassesWithID(id: number): Observable<Glasses> {
    return this.http.get<Glasses>(BASE_URI + '/glasses/find/' + id);
  }

  getGlassesReviewId(id: number): Observable<Glass[]> {
    return this.http.get<Glass[]>(`${BASE_URI}/glasses/${id}/reviews`);

  }

  addGlassesReview(glass: Glass): Observable<Glass> { 
    return this.http.post<Glass>(BASE_URI + '/review/add', glass);
  }

  getUniqueShapes(products: Glasses[]): string[] {
    const shapes = ['All'];
    products.forEach(product => {
      if (!shapes.includes(product.shape)) {
        shapes.push(product.shape);
      }
    });
    return shapes;
  }

  getUniqueBrands(products: Glasses[]): string[] {
    const brands = ['All'];
    products.forEach(product => {
      if (!brands.includes(product.brand)) {
        brands.push(product.brand);
      }
    });
    return brands;
  }

}
