import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.css'
})
export class LogoutComponent {
  constructor(private router:Router){
    // this.logout();
    this.LogoutConfirmation();
     }
    //  logout(){
    //   localStorage.removeItem("username");
    //   this.router.navigateByUrl('/');
    //  }
     LogoutConfirmation(): void {
     this.openLogoutConfirmation().then((confirmed) => {
        if (confirmed) {
          sessionStorage.removeItem("username");
          sessionStorage.removeItem("user");
            this.router.navigateByUrl('/');
        }
        else{
          this.router.navigateByUrl('/home');


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




