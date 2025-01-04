import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-delieveryhomepage',
  templateUrl: './delieveryhomepage.component.html',
  styleUrl: './delieveryhomepage.component.css'
})
export class DelieveryhomepageComponent {

  constructor(private router:Router){
  }
  deliverypage(){
    this.router.navigateByUrl('delieveryhome');
  }
  logout(){
    this.LogoutConfirmation();
  }
  LogoutConfirmation(): void {
    this.openLogoutConfirmation().then((confirmed) => {
       if (confirmed) {
         sessionStorage.removeItem("username");
         sessionStorage.removeItem("deliveryPartner");
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
