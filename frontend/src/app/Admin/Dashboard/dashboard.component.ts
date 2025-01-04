import { BreakpointObserver } from '@angular/cdk/layout';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  title = 'material-responsive-sidenav';
  @ViewChild(MatSidenav) sidenav!: MatSidenav;
  isMobile= true;
  isCollapsed = true;

  baseUrl: any = "http://localhost:8081";

  isVendor:boolean=false;
  isDelivery:boolean=false;
  isCustomer:boolean=false;

  vendorStatus = '';
  deliveryPartnerStatus='';

  vendors: any[] = [];
  deliveryPartners: any[] = [];

  constructor(private http: HttpClient,private router: Router) {}

  ngOnInit():void {
    // Your breakpoint observer logic
    this.showCustomers();
    /*
    this.isCustomer=false;
    this.isVendor = false;
    this.isDelivery = true;
    this.http.get<any[]>(`${this.baseUrl}/delivery/getDeliveryPartners`).subscribe(
      response=>{
        console.log(response);
        this.deliveryPartners=response;   
      },
      error=>{
        console.log(error);
      }
        )*/
  }

  toggleMenu() {
    if(this.isMobile) {
      this.sidenav.toggle();
      this.isCollapsed = false;
    } else {
      this.sidenav.open();
      this.isCollapsed = !this.isCollapsed;
    }
  }

  
  logoutAdmin(){
    this.toggleMenu();
    this.LogoutConfirmation();
  }
 
  LogoutConfirmation(): void {
    this.openLogoutConfirmation().then((confirmed) => {
       if (confirmed) {
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


  showVendors() {
    // Navigate to the route where vendors table is displayed
    //this.router.navigate(['/vendors']);
    //this.isCollapsed = !this.isCollapsed;
    
    this.isVendor = true;
    this.isDelivery = false;
    this.isCustomer=false;
    this.toggleMenu();

    this.http.get<any[]>(`${this.baseUrl}/vendor/getVendors`).subscribe(
      response=>{
        console.log(response);
        this.vendors=response;    
      },
      error=>{
        console.log(error);
      }
        )

  }

  makeVendorAccept(event: any,username:string){
    console.log("event"+event.value)
    console.log(this.vendorStatus)
    //console.log("event target"+event.target.value)
    
    const vendorObj={
      username:username,
      status:this.vendorStatus
    }
    this.http.post(`${this.baseUrl}/admin/vendorStatus`,vendorObj).subscribe(
      response=>{
        console.log(response);
          if(response==true)
          {
            Swal.fire({
              icon: 'success',
              title: 'Access Grant!',
              text: 'Vendor Access has been Accepted.',
            });
   
          }
          else{
            Swal.fire({
              icon: 'error',
              title: 'Access Denied',
              text: 'Vendor Access has been Rejected.',
            });  
          }
          this.showVendors();
      },
      error=>{
        console.log(error);
            
        Swal.fire({
          icon: 'error',
          title: 'Action Failed',
          text: 'Invalid Actions. Please try again.',
          });
      }
    )
  }

  showDeliveryPartners() {
    // Navigate to the route where delivery partners table is displayed
    //this.router.navigate(['/delivery-partners']);
    //this.isCollapsed = !this.isCollapsed;
    this.isCustomer=false;
    this.isVendor = false;
    this.isDelivery = true;
    this.toggleMenu();

    this.http.get<any[]>(`${this.baseUrl}/delivery/getDeliveryPartners`).subscribe(
      response=>{
        console.log(response);
        this.deliveryPartners=response;   
      },
      error=>{
        console.log(error);
      }
        )

  }

  makeDeliveryAccept(event: any,username:string){
    const deliveryObj={
      username:username,
      status:this.deliveryPartnerStatus
    }

    this.http.post(`${this.baseUrl}/admin/deliveryStatus`,deliveryObj).subscribe(
        response=>{
          console.log(response);
            if(response==true)
            {
              Swal.fire({
                icon: 'success',
                title: 'Access Grant!',
                text: 'Delivery Partner Access has been Accepted.',
              });
          
            }
            else{
              Swal.fire({
                icon: 'error',
                title: 'Access Denied',
                text: 'Delivery Partner Access has been Rejected.',
              });
          
            }
            this.showDeliveryPartners();
        },
        error=>{
          console.log(error);
              
          Swal.fire({
            icon: 'error',
            title: 'Action Failed',
            text: 'Invalid Actions. Please try again.',
            });
      }
      )
  }

  showCustomers(){
    this.isVendor = false;
    this.isDelivery = false;
    this.isCustomer=true;
    this.toggleMenu();
  }

  
}
