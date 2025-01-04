import { Component, OnInit } from '@angular/core';
import { UpdateprofileComponent } from '../homepage/updateprofile/updateprofile.component';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{
  userid:any="";
  userinfo:any={};
constructor(private http:HttpClient){
  console.log(this.userid)
  this.getUser();
  console.log(this.userinfo)

}
ngOnInit(): void {
  this.userid=sessionStorage.getItem('username');
   this.getUser();
}
getUser(){

  this.userid=sessionStorage.getItem('username');


  this.http.get(`http://localhost:8081/user/getuser/${this.userid}`).subscribe(
    (response:any)=>{

      console.log(response)
      this.userinfo=response;
    },
  (error:any)=>{
    console.log(error)
  }
  )
}
updateUser(user: any) {
  this.userinfo = user;
  sessionStorage.setItem('user', JSON.stringify(this.userinfo));
}
}
