import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orderhistory',
  templateUrl: './orderhistory.component.html',
  styleUrl: './orderhistory.component.css'
})
export class OrderhistoryComponent implements OnInit {

  orderss: any[] = [];
  userinfo: any = {};
  products:any[]=[];
  totalPrice:any="";

  private baseUrl: any = "http://localhost:8081";

  constructor(private http: HttpClient,private router: Router) { }

  ngOnInit(): void {
    const userData = sessionStorage.getItem('user');
    if (userData) {
      this.userinfo = JSON.parse(userData);
    }

    // Initialize a demo order object with placeholder values
    this.http.get<any[]>(`${this.baseUrl}/order/getOrdersByUsername/${this.userinfo?.username}`).subscribe(
      (response:any) => {
        console.log("response", response);
        if (Array.isArray(response)) { // Check if response is an array
          this.orderss = response;
              this.calculateTotalPrice();
        } else {
          console.error("Response is not an array:", response);
        }
      },
      (error:any) => {
        console.log(error);
      }
    );

  }
  calculateTotalPrice(): void {
    this.totalPrice = 0; // Reset total price
    this.orderss.forEach(order => {
      order.productsList.forEach((product:any) => {
        this.totalPrice += product.price; // Assuming there's a price property in the product object
      });
    });
  }

}
