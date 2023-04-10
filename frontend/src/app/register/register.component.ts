import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit{
  registerForm: FormGroup;
  users: User[];

  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private router: Router) {
    this.registerForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(4)]],
      role: ['customer', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      billing_address: ['', [Validators.required]],
      mailing_address: ['', [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.loginService.getUser().subscribe({
      next: (response) => {
        this.users = response;
      }
    })
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      const user: User = {
        userName: this.registerForm.get('username')?.value,
        password: this.registerForm.get('password')?.value,
        role: this.registerForm.get('role')?.value,
        billingAddress: this.registerForm.get('billing_address')?.value,
        mailingAddress: this.registerForm.get('mailing_address')?.value,
        email: this.registerForm.get('email')?.value,
      };
      this.loginService.addUser(user).subscribe({
        next: (response) => {
          if (response) {
            alert('User registered successfully!');
            this.router.navigate(['/login']);
          } else {
            alert('User already exists!');
          }
        }
      })
      
    }
  }
}
