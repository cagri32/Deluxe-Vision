import { EventEmitter, Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

export const BASE_URI: string = "http://localhost:8080"


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private users: User[];
  private loggedInUser: User | null = null;
  userLoggedIn = new EventEmitter<any>();


  constructor(private http: HttpClient,private router: Router) { }

  getUser() {
    return this.http.get<User[]>(BASE_URI + '/user/all');
  }

  login(username: string, password: string){
    this.getUser().subscribe({
      next: (response) => {
        this.users = response;
      },
      complete: () => {
        const user = this.users.find(user => user.userName === username && user.password === password);
        if (user) {
          this.loggedInUser = user;
          localStorage.setItem('loggedInUser', JSON.stringify(this.loggedInUser));
          this.userLoggedIn.emit(this.loggedInUser);
          alert('login successful!');
          this.router.navigate(['/shop']);
        }
        else {
          alert('Invalid username or password')
        }
      }
    });
  }
  

  logout() {
    this.loggedInUser = null;
    localStorage.removeItem('loggedInUser');
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(BASE_URI + '/user/add', user);
  }

  register(user: User, users: User[]): boolean {
    if (users.find(u => u.userName === user.userName)) {
      return false; // User already exists
    } else {
      this.addUser(user);
      return true;
    }
  }

  getLoggedInUser(): User | null {
    if (!this.loggedInUser) {
      const userJson = localStorage.getItem('loggedInUser');
      if (userJson) {
        this.loggedInUser = JSON.parse(userJson);
      }
    }
    return this.loggedInUser;
  }

  isLoggedIn(): boolean {
    return this.getLoggedInUser() !== null;
  }
}
