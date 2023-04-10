import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ProductComponent } from './product/product.component';
import { AboutComponent } from './about/about.component';
import { LandingComponent } from './landing/landing.component';
import { ShopComponent } from './shop/shop.component';
import { RegisterComponent } from './register/register.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { CheckoutCardComponent } from './checkout/checkoutCard/checkout-card/checkout-card.component';

const routes: Routes =
  [
    { path: 'login', component: LoginComponent },
    { path: 'product', component: ProductComponent },
    { path: '', component: LandingComponent, pathMatch: 'full' },
    { path: 'about', component: AboutComponent},
    { path: 'shop', component: ShopComponent},
    { path: 'register', component: RegisterComponent },
    { path: 'shop/:id', component: ProductComponent },
    { path: 'checkout', component: CheckoutComponent},
    { path: 'checkout/card', component: CheckoutCardComponent}

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
