import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {

  cartproducts: any[] = []; // You can replace 'any' with a more specific type for your products

  constructor() {}

  setCartProducts(products: any) {
 this.cartproducts=products;
  }

  getCartProducts() {
    console.log(this.cartproducts);

    return this.cartproducts;
  }
}
