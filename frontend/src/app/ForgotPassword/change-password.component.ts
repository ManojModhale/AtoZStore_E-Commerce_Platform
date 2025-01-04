import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrl: './change-password.component.css'
})
export class ChangePasswordComponent {
  private baseUrl:any = 'http://localhost:8081/user';
  header:String="Reset Password";
  description:String="Lost your password? Please enter your username and email address. You will receive a link to create a new password via email.";

  otpdesc:String="Verification required";
  otpver:String="To continue, complete this verification step. We've sent a One Time Password (OTP) to the email . Please enter it below."

 newpassword:String="Create new password";
newdesc:String="We'll ask for this password whenever you Sign-In.";


  isSubmited:boolean=false;
  generatedOTP:number=0;

  constructor(private http: HttpClient, private router: Router) {

  }

  showOtp = false;
  //,Validators.pattern(/^[0-9]{6}$/)
  showNewPassword = false;

  forgotPasswordForm=new FormGroup({
    username:new FormControl("",[Validators.required,Validators.pattern(/^\S*$/)]),
    email:new FormControl("",[Validators.required,Validators.email]),
    otp:new FormControl("",[Validators.required]),
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

  get otp():any{
    return this.forgotPasswordForm.get('otp');
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

  verifyOtp() {
    if (this.generatedOTP == this.otp.value) {
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
