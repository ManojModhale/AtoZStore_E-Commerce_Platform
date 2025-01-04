import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CartServiceService } from '../Services/cart-service.service';

@Component({
  selector: 'app-cartpage',
  templateUrl: './cartpage.component.html',
  styleUrl: './cartpage.component.css'
})
export class CartpageComponent {
  products:any=[];
  user:any={};
  selectedQuantity:number[]=[];

  sum:number=0;
  quantity: number[] = [1,2,3,4,5,6,7,8,9,10];




  baseurl="http://localhost:8081"
  constructor(private http:HttpClient,private router:Router,private cartService: CartServiceService){
  this.user=sessionStorage.getItem('user');
  this.user=JSON.parse(this.user);



  }
  ngOnInit(): void {


    this.getCartProducts()





}


getCartProducts(){
  this.http.get<any[]>(`${this.baseurl}/cart/getcartproducts/${this.user?.username}`).subscribe(
response=>{
  console.log(response);

  this.products=response;
  console.log(this.products)
  this.cartService.setCartProducts(this.products);
this.calculateprice();

},
error=>{
  console.log(error);
}
  )
}
removeFromCart(product:any){

  const formdata=new FormData();
  formdata.append("username",this.user.username);
  formdata.append("cartproductid",product.cartproductId);
  this.http.post(`${this.baseurl}/cart/deleteFromCart`, formdata).subscribe(
    response=>{
      console.log(response);
       // Subtract the price of the removed product from the total sum

     this.getCartProducts()
    },
    error=>{
      console.log(error);
    }
      )
}
calculateprice(){
  this.sum=0;
  this.products.forEach((element:any) => {
    console.log(element)
    if(element.offer!=='null' && element.offer!==null){

    this.sum=this.sum+this.calculateDiscountedPrice(element)*element.quantity;
    }
    else{
    this.sum=this.sum+element.price*element.quantity
    }
    console.log("total :"+this.sum)
  });
}
gotoCategory(){
  this.router.navigateByUrl("home")
}
AddTotalAmount(product:any,index:any){

  if(product.offer!=='null'){

    this.sum=this.sum+this.calculateDiscountedPrice(product);
    }
    else{
    this.sum=this.sum+product.price
    }
   this.updateProductQuantity("add",product);
  this.products[index].quantity+=1;
}

subtractTotalAmount(product:any,index:any){
  if(this.products[index].quantity>1){
  if(product.offer!=='null'){

    this.sum-=this.calculateDiscountedPrice(product);
    }
    else{
    this.sum-=product.price
    }
    this.updateProductQuantity("subtract",product);
  this.products[index].quantity-=1;
    }
}
calculateDiscountedPrice(element:any):number{
  const discountPercentage = parseFloat(element.offer.replace('%', ''));



  const finalPrice = element.price - (element.price * discountPercentage / 100);

  return finalPrice;
}
updateProductQuantity(update:any,product:any){
    this.http.post(`${this.baseurl}/cart/productquantity/${update}/${this.user.username}`, product).subscribe(
    (success:any)=>{

    },
    error=>{

    }
   )
}
}