import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-notfound',
  templateUrl: './notfound.component.html',
  styleUrls: ['./notfound.component.css']
})
export class NotfoundComponent {

  //notfoundimg:string="https://images.unsplash.com/photo-1584824486509-112e4181ff6b?ixlib=rb-4.0.3&amp;ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8NDA0fGVufDB8fDB8fA%3D%3D&amp;auto=format&amp;fit=crop&amp;w=800&amp;q=60";

  constructor(private location: Location,private router: Router){

  }

  backClicked(){
    console.log('Button clicked');
    this.location.back();
  }

}
