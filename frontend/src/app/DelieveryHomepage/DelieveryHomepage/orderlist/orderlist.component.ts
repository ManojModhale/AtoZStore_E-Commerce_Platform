import { Component, Input, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrl: './orderlist.component.css'
})
export class OrderlistComponent {
  @Input() order:any;
  totalPrice: number = 0;
  constructor(){

  }
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['order'] && !changes['order'].firstChange) {
      // Call your method here
     this.calculateTotalPrice()
    }
  }



  calculateTotalPrice() {
    this.totalPrice=0;
    console.log("Order:", JSON.stringify(this.order));


    if (this.order && this.order.productsList && this.order.productsList.length > 0) {

      // Summing up the prices using reduce method
      this.totalPrice = this.order.productsList.reduce((total: number, product: any) => {
        return total + (product.price || 0);
      }, 0);
    }
  }

}
