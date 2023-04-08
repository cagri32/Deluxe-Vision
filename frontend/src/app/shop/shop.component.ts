import { Component, OnInit } from '@angular/core';
import { GlassesService } from '../services/glasses.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit {

  glasses: any;

  constructor(
    private glassesService: GlassesService
  ){}

  ngOnInit(): void {
      this.glasses = this.glassesService.getAllGlasses();
  }


}
