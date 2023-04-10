import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { Glass } from 'src/app/models/glass';
import { GlassesService } from 'src/app/services/glasses.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-review-dialog',
  templateUrl: './review-dialog.component.html',
  styleUrls: ['./review-dialog.component.scss']
})
export class ReviewDialogComponent implements OnInit {
  glassForm: FormGroup;
  productId: number;

  fullName: string;
  glassesId: number;
  rating: number;
  review: string;
  reviewId: number;
  title: string;
  userName: string;
  user: any;
  loggedInUser: any;


  constructor(
    private fb: FormBuilder, 
    private glassesService: GlassesService, 
    private route: ActivatedRoute, 
    private dialogRef: MatDialogRef<ReviewDialogComponent>,
    private loginService: LoginService,
    @Inject(MAT_DIALOG_DATA) public data: { productId: number }
    ) {
    this.glassForm = this.fb.group({
      fullName: ['', Validators.required],
      rating: ['', Validators.required],
      review: ['', Validators.required],
      title: ['', Validators.required],
    });
  }

  ngOnInit(): void {

    const min = Math.ceil(50);
    const max = Math.floor(100000);
    this.reviewId = Math.floor(Math.random() * (max - min) + min);
    this.user = this.loginService.getLoggedInUser();
    if (this.user) {
      this.loggedInUser = true;
    }
    this.loginService.userLoggedIn.subscribe(user => {
      this.loggedInUser = true;
      this.user = this.loginService.getLoggedInUser();
    });

  }

  onSubmit() {
    const glass: Glass = {
      fullName: this.glassForm.get('fullName')?.value,
      glassesId: this.data.productId,
      rating: this.glassForm.get('rating')?.value,
      review: this.glassForm.get('review')?.value,
      reviewId: this.reviewId,
      title: this.glassForm.get('title')?.value,
      userName: this.user.userName
    };
    this.glassesService.addGlassesReview(glass).subscribe({
      next: (response) => {
        this.dialogRef.close();
      }
    })
    
  }
}

