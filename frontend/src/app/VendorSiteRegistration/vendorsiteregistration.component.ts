import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-vendorsiteregistration',
  templateUrl: './vendorsiteregistration.component.html',
  styleUrl: './vendorsiteregistration.component.css'
})
export class VendorsiteregistrationComponent {

  private baseUrl:any = "http://localhost:8081";

  isSubmited:boolean=false;

  constructor(private http: HttpClient,private router: Router,private formBuilder:FormBuilder) {

  }

  ngOnInit(): void {

  }

  signin=new FormGroup({
    status:new FormControl("Denied",),
    firstname:new FormControl("",[Validators.required,Validators.pattern(/^[A-Z][a-z]*$/)]),
    lastname:new FormControl("",[Validators.required,Validators.pattern(/^[A-Z][a-z]*$/)]),
    gender:new FormControl("",[Validators.required]),
    age: new FormControl("", [Validators.required]),
    email:new FormControl("",[Validators.required,Validators.email]),
    contactno:new FormControl("",[Validators.required,Validators.pattern(/^[0-9]{10}$/)]),
    username:new FormControl("",[Validators.required,Validators.pattern(/^\S*$/)]),
    password:new FormControl("",[Validators.required,Validators.minLength(8),Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&]).{4,20}$/)]),
    confirmpass:new FormControl("",[Validators.required, this.matchPassword.bind(this)]),

    companyname:new FormControl("",[Validators.required]),
    companytype:new FormControl("",[Validators.required]),

    street:new FormControl("",[Validators.required]),
    city:new FormControl("",[Validators.required]),
    state:new FormControl("",[Validators.required]),
    landmark:new FormControl("",[Validators.required]),
    country:new FormControl("",[Validators.required]),
    pincode:new FormControl("",[Validators.required]),

  });

   matchPassword(control: AbstractControl): { [key: string]: boolean } | null {
    if (!this.signin || !this.signin.get('password')) {
       console.error('Form or password control not initialized.');
       return { 'passwordMismatch': true };
     }

     const password = this.signin.get('password')?.value;
    const confirmPassword = control.value;

     return password === confirmPassword ? null : { 'passwordMismatch': true };
  }

  get status():any{
    return this.signin.get('status');
  }

  get firstname():any{
    return this.signin.get('firstname');
  }

  get lastname():any{
    return this.signin.get('lastname');
  }

  get gender():any{
    return this.signin.get('gender');
  }

  get email():any{
    return this.signin.get('email');
  }

  get contactno():any{
    return this.signin.get('contactno');
  }

  get age():any{
    return this.signin.get('age');
  }


  get username():any{
    return this.signin.get('username');
  }

  get password():any{
    return this.signin.get('password');
  }

   get confirmpass():any{
     return this.signin.get('confirmpass');
  }
  get companyname():any{
    return this.signin.get('companyname');
 }

 get companytype():any{
  return this.signin.get('companytype');
}


get street():any{
  return this.signin.get('street');
}


get city():any{
  return this.signin.get('city');
}


get state():any{
  return this.signin.get('state');
}


get landmark():any{
  return this.signin.get('landmark');
}


get country():any{
  return this.signin.get('country');
}


get pincode():any{
  return this.signin.get('pincode');
}


  myForm:any;

  handleReset(){
    this.myForm=this.signin;
    this.myForm.resetForm();
  }

  handleSubmit() {
    this.isSubmited = true;
    this.myForm = this.signin;

    if (this.signin.valid)
    {
      const address={
        street:this.myForm.value.companytype,
        city: this.myForm.value.city,
        state: this.myForm.value.state,
        landMark: this.myForm.value.landmark,
        country: this.myForm.value.country,
        pincode: this.myForm.value.pincode,

       }

      const registeringData = {
        status:this.myForm.value.status,
        firstname: this.myForm.value.firstname,
        lastname: this.myForm.value.lastname,
        gender: this.myForm.value.gender,
        email: this.myForm.value.email,
        contactno: +this.myForm.value.contactno,
        age: this.myForm.value.age,
        username: this.myForm.value.username,
        password: this.myForm.value.password,
        companyname:this.myForm.value.companyname,
       companytype:this.myForm.value.companytype,
       address:address

      }




      console.log(registeringData);

      this.http.post(this.baseUrl + "/vendor/vendorRegister", registeringData).subscribe(
        (response: any) => {
          // Handle success response
          alert("Registered successfully!");
          console.log(response);

          Swal.fire({
            icon: 'success',
            title: 'Registration Successful!',
            text: 'Thank you for registering!',
          });

          this.router.navigateByUrl('/login');



        },
        (error: any) => {
          // Handle error response
          // alert("Error in registration: " + error.message);
         console.error('Error Register:', error);

          Swal.fire({
            icon: 'error',
            title: 'Error in Registration',
            text: 'There was an error during registration. Please try again later.',
          });

        }
      );

    }
  }

}
