import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-productcategory',
  templateUrl: './productcategory.component.html',
  styleUrl: './productcategory.component.css'
})
export class ProductcategoryComponent {
  showfilters:boolean=false;
  products:any=[];
  category:any="";
  constructor(private route: ActivatedRoute,private http:HttpClient,private router:Router) {

  }
 baseUrl:any="http://localhost:8081/product";
  ngOnInit(): void {

    this.route.paramMap.subscribe((params) => {

      this.category = params.get('category');
      this.getProducts();
    console.log(this.category)
    //alert(this.category)
    //localStorage.setItem("category", this.category);

  }

    )
}
handleClick(){
  this.showfilters=!this.showfilters;
}
getProducts(){

  this.http.get<any[]>(`http://localhost:8081/product/getProductByCategory/${this.category}`).subscribe(
    response=>{
      console.log(response)
  this.products=response;
    },
    error=>{
      console.log(error)
    }
  )
}
handlePriceFilter(eventData: { min: any, max: any }) {

  const min = eventData.min;
  const max = eventData.max;
  const formdata=new FormData();
  formdata.append('min',min)
  formdata.append('max',max)
  this.http.post(`http://localhost:8081/product/byPriceRange/${this.category}`,formdata).subscribe(
    success=>{
      this.products=success;
    },
    error=>{
      console.log(error);

    }
  )

}
gotoCategory(){
  this.router.navigateByUrl("home")
}
}
