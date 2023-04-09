import { EventEmitter, Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private users: User[] = [
    { username: 'john@example.com', password: '123456', role: 'admin' },
    { username: 'jane@example.com', password: 'abcdef', role: 'standard' }
  ];
  private loggedInUser: User | null = null;
  userLoggedIn = new EventEmitter<any>();

  constructor() { }

  getUser() {
    return this.users;
  }

  login(username: string, password: string): boolean {
    const user = this.users.find(user => user.username === username && user.password === password);
    if (user) {
      this.loggedInUser = user;
      localStorage.setItem('loggedInUser', JSON.stringify(this.loggedInUser));
      this.userLoggedIn.emit(this.loggedInUser);
      return true;
    } else {
      return false;
    }
  }

  logout() {
    this.loggedInUser = null;
    localStorage.removeItem('loggedInUser');
  }

  register(user: User): boolean {
    if (this.users.find(u => u.username === user.username)) {
      return false; // User already exists
    } else {
      this.users.push(user);
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
