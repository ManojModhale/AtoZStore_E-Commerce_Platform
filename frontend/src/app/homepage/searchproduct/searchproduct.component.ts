import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductdialogComponent } from '../productdialog/productdialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-searchproduct',
  templateUrl: './searchproduct.component.html',
  styleUrl: './searchproduct.component.css'
})
export class SearchproductComponent {
  searchprod:any="";
  searchedProducts:any=[];
  baseurl="http://localhost:8081";
  isLoading:boolean=true;
  noProductFound:boolean=false;
  constructor(private route: ActivatedRoute,private http:HttpClient,private router:Router,public dialog: MatDialog) {

  }
  ngOnInit(): void {

    this.route.paramMap.subscribe((params) => {

this.searchprod= params.get('searchpro');

    console.log(this.searchprod)
    if(this.searchprod.length>3){
      this.isLoading=false;
this.getProducts()

    }

  }

    )
}
getProducts(){

  this.http.get<any[]>(this.baseurl+`/product/searchproducts/${this.searchprod}`).subscribe(
    success=>{

      this.searchedProducts=success
      if(this.searchedProducts.length==0){
        this.noProductFound=true;
      }else{
        this.noProductFound=false;

      }
      console.log(this.searchedProducts)
    },
    error=>{
      console.log(error)
    }
  )
}
openDialog(product: any) {
  const dialogRef = this.dialog.open(ProductdialogComponent, {
    data: product
  });

//   dialogRef.afterClosed().subscribe(result => {
//     // Handle any actions after the dialog is closed, if needed
//     console.log('The dialog was closed');
//   });
}
}
