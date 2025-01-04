import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-addimage',
  templateUrl: './addimage.component.html',
  styleUrl: './addimage.component.css'
})
export class AddimageComponent {
  selectedFile!: any;
  imagepreview:any="";

  addproduct=new FormGroup({
    productid:new FormControl("",),

  })
  productinfo: any;


  constructor(private http:HttpClient){

  }

  getImage(event: any) {

    this.selectedFile=event.target.files[0];
    this.imagepreview=URL.createObjectURL(this.selectedFile);
  }



  handleSubmit(){
    this.productinfo=this.addproduct.value;
    this.productinfo.productid = parseInt( this.productinfo.productid);
     const formData=new FormData();
    formData.append('image',this.selectedFile);


    this.http.post(`http://localhost:8081/uploadImage/${this.productinfo.productid}`, formData).subscribe(
      (response) => {
        console.log('Image uploaded successfully!', response);
        alert("product added successfully")
        // Handle any additional logic after successful image upload
      },
      (error) => {
        console.error('Error uploading image', error);
        alert("error while adding image")
        // Handle error
      }
    );


  }

}
