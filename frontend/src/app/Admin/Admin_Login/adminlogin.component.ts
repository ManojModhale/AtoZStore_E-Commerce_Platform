import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrl: './adminlogin.component.css'
})
export class AdminloginComponent {

  private baseUrl:any = "http://localhost:8081";
  username: string = '';
  password: string = '';

  constructor(private http: HttpClient,private router: Router) {

  }
  
  authenticateAdmin() {
    this.http.post<any>(`${this.baseUrl}/admin/adminAuthentication`, { username: this.username, password: this.password })
      .subscribe(
        (response) => {
          if (response && response.success) {
            Swal.fire({
              icon: 'success',
              title: 'Admin Login',
              text: 'Login Successful!',
            });
            this.router.navigateByUrl("/dashboard");
          } else {
            Swal.fire({
              icon: 'error',
              title: 'Wrong Credentials',
              text: 'Please check your username and password.',
            });
          }
        },
        error => {
          Swal.fire({
            icon: 'error',
            title: 'Login Failed',
            text: 'Invalid username or password. Please try again.',
          });
          console.log(error);
        }
      );
  }
  


}
