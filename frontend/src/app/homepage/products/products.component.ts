


import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { Router ,ActivatedRoute} from '@angular/router';
import {
  MatDialog,
  MAT_DIALOG_DATA,
  MatDialogTitle,
  MatDialogContent,
} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import { ProductdialogComponent } from '../productdialog/productdialog.component';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css',

})
export class ProductsComponent {
  @Input() products:any=[

  ];
  @ViewChild('productsContainer') productsContainer!: ElementRef;




   pageSize = 6;
  currentPage = 1;
  user:any={};
  selectedSize: string | null = null;
  selectedColor!:String;











  //private baseUrl:any = 'http://localhost:8081/product/getProductByCategory';


   baseurl="http://localhost:8081"
   constructor(private http:HttpClient,private router:Router,private route: ActivatedRoute,public dialog: MatDialog){

    for(let i of this.products){
      console.log(i.imageFile.filePath);

    }


   }


   get displayedProducts(): any[] {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    return this.products.slice(startIndex, endIndex);
  }

  onPageChange(page: number): void {
    this.currentPage = page;
    this.scrollToTop();
    this.router.navigate([], {
      relativeTo: this.route,
      queryParams: { page: this.currentPage },
      queryParamsHandling: 'merge',
    });
  }
/*
   getProducts(){
    //alert(this.category);
    this.http.get(`http://localhost:8081/product/getProductByCategory/${this.category}`).subscribe(
      (result:any)=>{
        console.log(result);
        this.products=result;
      },
      (error:any)=>{
        console.log(error)
      }
      )
*/

scrollToTop(): void {
  this.productsContainer.nativeElement.scrollTop = 0;
}


  openDialog(product: any) {
    const dialogRef = this.dialog.open(ProductdialogComponent, {
      data: product
    }
    );

  //   dialogRef.afterClosed().subscribe(result => {
  //     // Handle any actions after the dialog is closed, if needed
  //     console.log('The dialog was closed');
  //   });
  }

}
