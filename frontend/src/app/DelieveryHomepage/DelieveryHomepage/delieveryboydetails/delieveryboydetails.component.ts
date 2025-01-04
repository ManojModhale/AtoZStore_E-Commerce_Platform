import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delieveryboydetails',
  templateUrl: './delieveryboydetails.component.html',
  styleUrl: './delieveryboydetails.component.css'
})
export class DelieveryboydetailsComponent {
  showdropdown:boolean=false;
  baseUrl="http://localhost:8081/delivery"
  orderitem:any={};
  orders:any=[];
  constructor(private router:Router,private http:HttpClient){
    // this.orders=[
    //   {
    //     availability:"available",
    // username:"Shardul",
    // email:"shardul@gmail.com",
    // orderid:1,
    // contactno:9887909009,
    // street:"Baner",
    // state:"Maharahtra",

    // city:"Pune",
    // country:"India",
    // pincode:411058,
    // landmark:"banergaon",
    // productname:"Shirts",
    // color:"orange",
    // quantity:"3",
    // size:"64GB",

    // price:2000,
    //   },
    //   {
    //     availability:" not available",
    // username:"Soham",
    // email:"soham@gmail.com",
    // orderid:1,
    // contactno:9887909009,
    // street:"Baner",
    // state:"Maharahtra",

    // city:"Pune",
    // country:"India",
    // pincode:411058,
    // landmark:"banergaon",
    // productname:"Pants",
    // color:"red",
    // quantity:"5",
    // size:"64GB",

    // price:1000,
    //   },
    //   {
    //     availability:"available",
    // username:"Ajay",
    // email:"ajay@gmail.com",
    // orderid:1,
    // contactno:9887909009,
    // street:"Wakad",
    // state:"Maharahtra",

    // city:"Pune",
    // country:"India",
    // pincode:411058,
    // landmark:"Ravet",
    // productname:"Laptop",
    // color:"black",
    // quantity:"1",
    // size:"64GB",

    // price:42000,
    //   },
    //   {
    //     availability:"available",
    // username:"Shreya",
    // email:"shreya@gmail.com",
    // orderid:1,
    // contactno:9887909009,
    // street:"Bhavdhan",
    // state:"Maharahtra",

    // city:"Pune",
    // country:"India",
    // pincode:411058,
    // landmark:"Chinchowk",
    // productname:"Lipstick",
    // color:"pink",
    // quantity:"1",
    // size:"64GB",

    // price:500,
    //   },

    // ]
  }

  ngOnInit(): void {
    // Fetch delivery boy details from API
    this.http.get<any[]>(this.baseUrl+'/getAllOrders').subscribe(
      (response: any[]) => {

        this.orders = response;
        this.orderitem=this.orders[0];
      },
      (error: any) => {
        console.log("Error fetching delivery boy details:", error);
      }
    );
  }

  changeDropDown(){
   this.showdropdown=!this.showdropdown;

  }
  showprodinfo(order:any){
    this.orderitem=order;
  }


}




