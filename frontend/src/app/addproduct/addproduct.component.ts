import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent {

  private baseUrl:any = 'http://localhost:8081/product/newproduct';
  vendor:any="";
  //dynamically add fields this is correct logic code
  selectedFile!: any;
  imagepreview: any = "";
  productForm: FormGroup;

  constructor(private http: HttpClient, private fb: FormBuilder) {
    this.productForm = this.fb.group({
      productid: ['', Validators.required],
      productname: ['', Validators.required],
      category: ['', Validators.required],
      price: ['', [Validators.required, Validators.min(0)]],
      quantity: ['', [Validators.required, Validators.min(0)]],
      offer: ['null'],
      description: ['', Validators.required],
      colors: this.fb.array([
        this.fb.group({ color: ['', Validators.required] })
      ]),
      sizes: this.fb.array([
        this.fb.group({ size: ['', Validators.required] })
      ]),
      selectedFile: ['']
    });
    this.vendor=sessionStorage.getItem('user');
    this.vendor=JSON.parse(this.vendor);
  }

  colors(): FormArray {
    return this.productForm.get('colors') as FormArray;
  }

  sizes(): FormArray {
    return this.productForm.get('sizes') as FormArray;
  }

  addColor() {
    this.colors().push(this.fb.group({ color: ['', Validators.required] }));
  }

  removeColor(index: number) {
    this.colors().removeAt(index);
  }

  addSize() {
    this.sizes().push(this.fb.group({ size: ['', Validators.required] }));
  }

  removeSize(index: number) {
    this.sizes().removeAt(index);
  }

  getImage(event: any) {
    this.selectedFile = event.target.files[0];
    this.imagepreview = URL.createObjectURL(this.selectedFile);

    // Update the productForm with the selected file
    this.productForm.patchValue({
      selectedFile: this.selectedFile
    });
}

product:any={};


sendData() {
  if (this.productForm.valid) {
    const formData = this.productForm.value;
    formData.price = parseInt(formData.price, 10);
    formData.productid = parseInt(formData.productid, 10);
    formData.colors = JSON.stringify(formData.colors);
    formData.sizes = JSON.stringify(formData.sizes);
    const formDataToSend = new FormData();
    Object.keys(formData).forEach(key => {
      formDataToSend.append(key, formData[key]);
    });
    formDataToSend.append('image', this.selectedFile);


    formDataToSend.append('vendorid',this.vendor.username)
    alert(formDataToSend)
    console.log(formDataToSend);

    this.http.post('http://localhost:8081/product/newproduct', formDataToSend).subscribe(
      (response) => {
        console.log('Request successful!', response);
        Swal.fire({
          icon: 'success',
          title: 'Product Added Successfully!',
          text: 'Your product has been successfully added.',
        }).then(() => {
          this.resetForm();
        });
      },
      (error) => {
        console.error('Error sending product data', error);
        Swal.fire({
          icon: 'error',
          title: 'Error!',
          text: 'An error occurred while adding the product. Please try again later.',
        });
      }
    );
  } else {
    Swal.fire({
      icon: 'error',
      title: 'Form Validation Error!',
      text: 'Please fill all required fields and provide valid inputs.',
    });
  }
}

resetForm() {
  this.productForm.reset();
  this.imagepreview = '';
  this.selectedFile = null;
}

}
