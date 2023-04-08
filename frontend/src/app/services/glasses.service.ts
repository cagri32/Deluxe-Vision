import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GlassesService {

  constructor(private http: HttpClient) { }

  getAllGlasses() {
    return this.http.get('/glasses/all');
  }
}
