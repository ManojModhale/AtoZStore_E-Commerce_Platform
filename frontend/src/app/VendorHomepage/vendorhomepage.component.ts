import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-vendorhomepage',
  templateUrl: './vendorhomepage.component.html',
  styleUrl: './vendorhomepage.component.css'
})
export class VendorhomepageComponent {


  constructor(private router:Router){
  }
  vendorpage(){
    this.router.navigateByUrl('/vendor');
  }
  logout(){
    this.LogoutConfirmation();
  }
  LogoutConfirmation(): void {
    this.openLogoutConfirmation().then((confirmed) => {
       if (confirmed) {
         sessionStorage.removeItem("username");
         sessionStorage.removeItem("vendor");
           this.router.navigateByUrl('/');
       }

     });

       }


   openLogoutConfirmation(): Promise<boolean> {
     return Swal.fire({
       title: 'Logout Confirmation',
       text: 'Are you sure you want to logout?',
       icon: 'question',
       showCancelButton: true,
       confirmButtonText: 'Logout',
       cancelButtonText: 'Cancel',
     }).then((result) => {
       return result.isConfirmed;
     });
   }


}
