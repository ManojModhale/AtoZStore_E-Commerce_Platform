import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-vendorforgetpassword',
  templateUrl: './vendorforgetpassword.component.html',
  styleUrl: './vendorforgetpassword.component.css'
})
export class VendorforgetpasswordComponent {

  private baseUrl:any = 'http://localhost:8081/vendor';
  header:String=" Reset Password";


 newpassword:String="Create new password";
newdesc:String="We'll ask for this password whenever you Sign-In.";

  isSubmited:boolean=false;
  generatedOTP:number=0;

  verificationResult:string="";
  otp:any="";
  otpform=new FormGroup(
   {
     num1:new FormControl(null),
     num2:new FormControl(null),
     num3:new FormControl(null),
     num4:new FormControl(null),
     num5:new FormControl(null),
     num6:new FormControl(null),

   }
  )



  constructor(private http: HttpClient, private router: Router) {

  }



  showOtp = false;
  //,Validators.pattern(/^[0-9]{6}$/)
  showNewPassword = false;

  forgotPasswordForm=new FormGroup({
    username:new FormControl("",[Validators.required,Validators.pattern(/^\S*$/)]),
    email:new FormControl("",[Validators.required,Validators.email]),

    password:new FormControl("",[Validators.required,Validators.minLength(8),Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&]).{4,20}$/)]),
    confirmpass:new FormControl("",[Validators.required, this.matchPassword.bind(this)])
  });

  matchPassword(control: AbstractControl): { [key: string]: boolean } | null {
    if (!this.forgotPasswordForm || !this.forgotPasswordForm.get('password')) {
      console.error('Form or password control not initialized.');
      return { 'passwordMismatch': true };
    }

    const password = this.forgotPasswordForm.get('password')?.value;
    const confirmPassword = control.value;

    return password === confirmPassword ? null : { 'passwordMismatch': true };
  }

  get username():any{
    return this.forgotPasswordForm.get('username');
  }

  get email():any{
    return this.forgotPasswordForm.get('email');
  }


  get password():any{
    return this.forgotPasswordForm.get('password');
  }

  get confirmpass():any{
    return this.forgotPasswordForm.get('confirmpass');
  }


  /* <------------------------------------------------> */

  // submitForm() {

  //   const forgotpassData = new FormData();
  //   forgotpassData.append('username', this.username.value);
  //   forgotpassData.append('email', this.email.value);

  //   console.log(forgotpassData);

  //   this.http.post(this.baseUrl + "/forgotpass", forgotpassData).subscribe(
  //     (response: any) => {
  //       // Handle success response

  //       console.log(response);

  //       if(response!=0)
  //           {
  //             alert("User Found successfully!");
  //             this.showOtp = true;
  //             this.generatedOTP=response;

  //           }
  //           else{
  //             alert("Wrong User")
  //             console.log('Wrong User', response);
  //           }
  //     },
  //     (error: any) => {
  //       // Handle error response
  //       alert("Error in Forgot Password: " + error.message);
  //       console.error('Error Register:', error);
  //     }
  //   );

  // }

  /* <------------------------------------------------> */

  submitForm() {
    const forgotpassData = new FormData();
    forgotpassData.append('username', this.username.value);
    forgotpassData.append('email', this.email.value);

    console.log(forgotpassData);

    this.http.post(this.baseUrl + "/forgotpass", forgotpassData).subscribe(
      (response: any) => {
        // Handle success response
        alert(response)
        console.log(response);

        if (response !== null) {
          this.showUserFoundAlert();
          this.showOtp = true;
          this.generatedOTP = response;
        } else {
          this.showWrongUserAlert();
          console.log('Wrong User', response);
        }
      },
      (error: any) => {
        // Handle error response
        this.showForgotPasswordErrorAlert(error.message);
        console.error('Error in Forgot Password:', error);
      }
    );
  }

  private showUserFoundAlert() {
    Swal.fire({
      icon: 'success',
      title: 'User Found Successfully!',
      text: 'The user has been found successfully.',
    });
  }

  private showWrongUserAlert() {
    Swal.fire({
      icon: 'error',
      title: 'Wrong User',
      text: 'The provided username or email is incorrect.',
    });
  }

  private showForgotPasswordErrorAlert(errorMessage: string) {
    Swal.fire({
      icon: 'error',
      title: 'Error in Forgot Password',
      text: `There was an error during the Forgot Password process: ${errorMessage}`,
    });
  }

  /* <------------------------------------------> */

  // verifyOtp() {
  //   if(this.generatedOTP==this.otp.value)
  //   {
  //     this.showNewPassword = true;
  //   }
  //   else{
  //     this.showNewPassword = false;
  //     alert("Entered Otp doesn't match with Generated Otp.....Please Check your email and try again.");
  //   }

  // }

   /* <------------------------------------------------> */

   moveToNext(currentIndex: number) {
    const currentInput = document.getElementById(`num${currentIndex}`) as HTMLInputElement;
    const nextIndex = currentIndex + 1;
    const nextInput = document.getElementById(`num${nextIndex}`) as HTMLInputElement;

    // Move focus to the next input box if available
    if (nextInput) {
      nextInput.focus();
    }
  }


  verifyOtp() {
    this.otp=this.otpform.value;
    this.otp = this.otp.num1+this.otp.num2+this.otp.num3+this.otp.num4+this.otp.num5+this.otp.num6;
    if (this.generatedOTP == this.otp) {
      this.showNewPassword = true;
      this.showOtpVerifiedAlert();
    } else {
      this.showNewPassword = false;
      this.showOtpMismatchAlert();
    }
  }

  private showOtpVerifiedAlert() {
    Swal.fire({
      icon: 'success',
      title: 'OTP Verified!',
      text: 'The OTP has been successfully verified.',
    });
  }

  private showOtpMismatchAlert() {
    Swal.fire({
      icon: 'error',
      title: 'OTP Mismatch',
      text: 'Entered OTP does not match with the generated OTP. Please check your email and try again.',
    });
  }


  /* <------------------------------------------------> */

  // updatePassword() {

  //   const changepass = new FormData();
  //   changepass.append('username', this.username.value);
  //   changepass.append('password', this.password.value);

  //   console.log(changepass);

  //   this.http.post(this.baseUrl + "/changepass", changepass).subscribe(
  //     (response: any) => {

  //       console.log(response);

  //         if(response==true)
  //           {
  //             alert("Password has been successfully Updated!");

  //             console.log("Password Change successful"+ response);
  //             this.router.navigateByUrl('/login');
  //           }
  //           else{
  //             alert("Not Updated Password")
  //             console.log("Not Updated Password"+ response);
  //           }
  //     },
  //     (error: any) => {
  //       // Handle error response
  //       alert("Error in Update Password: " + error.message);
  //       console.error('Error Update Passsord:', error);
  //     }
  //   );

  //   //console.log(this.forgotPasswordForm.value);
  //   // alert('Password updated successfully!');
  // }

  /* <------------------------------------------------> */





  updatePassword() {
    const changepass = new FormData();
    changepass.append('username', this.username.value);
    changepass.append('password', this.password.value);

    console.log(changepass);

    this.http.post(this.baseUrl + "/changepass", changepass).subscribe(
      (response: any) => {
        console.log(response);

        if (response === true) {
          this.showPasswordUpdateSuccessAlert();
          console.log("Password Change successful" + response);
          this.router.navigateByUrl('/login');
        } else {
          this.showNotUpdatedPasswordAlert();
          console.log("Not Updated Password" + response);
        }
      },
      (error: any) => {
        // Handle error response
        this.showPasswordUpdateErrorAlert(error.message);
        console.error('Error Update Password:', error);
      }
    );
  }

  private showPasswordUpdateSuccessAlert() {
    Swal.fire({
      icon: 'success',
      title: 'Password Updated!',
      text: 'Your password has been successfully updated.',
    });
  }

  private showNotUpdatedPasswordAlert() {
    Swal.fire({
      icon: 'error',
      title: 'Not Updated Password',
      text: 'There was an issue updating your password. Please try again.',
    });
  }

  private showPasswordUpdateErrorAlert(errorMessage?: string) {
    Swal.fire({
      icon: 'error',
      title: 'Error in Update Password',
      text: errorMessage || 'There was an error during password update. Please try again.',
    });
  }
}
