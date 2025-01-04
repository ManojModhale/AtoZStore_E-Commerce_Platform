import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Inject, OnInit, Output } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogContent, MatDialogRef, MatDialogTitle } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

import { data } from 'jquery';

import { Router } from '@angular/router';


@Component({
  selector: 'app-productdialog',
  templateUrl: './productdialog.component.html',
  styleUrl: './productdialog.component.css',

})
export class ProductdialogComponent implements OnInit{

  selectedColor:String=this.data.colors[0];
  user:any={};
  addingToCart:boolean=false;
  selectedSize: string=this.data.sizes[0];
  baseurl="http://localhost:8081";
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  isPresentInCart:boolean=false;
  constructor(
    public dialogRef: MatDialogRef<ProductdialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private http:HttpClient,
    private snak:MatSnackBar,
    private router:Router
  ) { console.log(data); }

    


ngOnInit(): void {
  this.CheckInCart()
}
  CheckInCart(){
    this.user=sessionStorage.getItem('user');
    const userinfo=JSON.parse(this.user);
    this.http.post(this.baseurl+`/cart/checkInCart/${userinfo.username}`,this.data.productid).subscribe(
      response=>{
      if(response==true){
        this.isPresentInCart=true;
      }

      },
      error=>{
        console.log(error)
      }
    )
  }

  addToCart(product:any){
    this.user=sessionStorage.getItem('user');
    const userinfo=JSON.parse(this.user);
    console.log(userinfo);
    this.addingToCart=true;


    const imageFile1={
      name:product.imageFile.name,
      type:product.imageFile.type,
      filePath:product.imageFile.filePath,
    }
  const cartproduct={
    productid:product.productid,
    productname:product.productname,
    category:product.category,
    price:product.price,
    description:product.description,
    cartimageFile:imageFile1,
    offer:product.offer,
    color:this.selectedColor,
    size:this.selectedSize,


  }

console.log("before backend"+cartproduct)
this.http.post<any[]>(this.baseurl+`/cart/addToCart/${userinfo.username}`,cartproduct).subscribe(
  response=>{
     console.log(response)
     setTimeout(() => {
      this.dialogRef.close();

        this.snak.open('Product Added to cart!!', 'ok', {
          horizontalPosition: this.horizontalPosition,
          verticalPosition:this.verticalPosition ,
          duration: 3000
        },);

    }, 1000);


     this.selectedSize="";
     this.selectedColor="";


  },
  error=>{
    console.log(error)
  }
)


  }

  onSizeSelected(event: Event) {
    const target = event.target as HTMLSelectElement;
    this.selectedSize = target.value;
    console.log('Selected Size:', this.selectedSize);
  }
  goToCart(){
    this.dialogRef.close();
    this.router.navigateByUrl('home/cart')
  }
}
