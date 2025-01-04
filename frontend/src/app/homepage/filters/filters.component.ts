import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrl: './filters.component.css'
})
export class FiltersComponent {
  backendUrl = 'http://localhost:8881';
  products: any[] = [];
  category: string = '';
  genFinal = ["Men", "Women","Kids",""];
  categories = ["Electronics", "Grocery", "Beauty", "Furniture", "Books","Fashion"];
  sizeFinal = ["S", "M", "L", "XL", "XXL"];
  colours = ["Red", "Blue", "Black", "White", "Yellow", "Green", "Gray", "Purple"];
  minPrice: any='';
  maxPrice: any='';
  @Output() priceFilterSubmit: EventEmitter<{ min: any, max: any }> = new EventEmitter();
prodArr:any[]=[];

  ngOnInit() {
    // You can perform any initialization logic here
    // For example, you might want to load initial data
    this.searchCategory();
  }


  constructor(private http: HttpClient,private router:Router) {
      this.show();
  }
  private baseUrl:any = 'http://localhost:8188/product';

  show(){
    this.http.get(this.baseUrl).subscribe(
      (Sussess:any)=>{
        console.error('Product get successfully:', Sussess);
         this.prodArr=Sussess;
      },
      (error:any)=>{
        // alert("Error adding product:"+error);
        console.error('Error adding product:', error);
      }

    );


}

selectCategory(event: any){
this.category=event.target.value;
this.searchCategory();
}

  searchCategory() {
    // Make an HTTP request to fetch products based on the category
    /*
    this.http.get<any[]>(`${this.backendUrl}/byCategory/${this.category}`).subscribe(
      (success) => {
        this.products = success.data;
        console.log(this.products);
      },
      (error) => {
        console.error(error);
      }
    );*/
    this.router.navigate(['home/products', this.category]);
  }

  handleChange(event: any) {
    // Handle changes when a filter option is selected
    this.category = event.target.value;
    
  }


  handlePriceFilterSubmit() {
    // Emit the min and max prices to the parent component
    this.priceFilterSubmit.emit({ min: this.minPrice, max: this.maxPrice });
  }
}
