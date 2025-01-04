import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, Output, TemplateRef, inject } from '@angular/core';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal, NgbModalOptions } from '@ng-bootstrap/ng-bootstrap';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';

@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrl: './updateprofile.component.css'
})
export class UpdateprofileComponent {
  @Output() userUpdated = new EventEmitter<any>();
 user!:any;

  constructor(private http:HttpClient,private router:Router){


  }

  private modalService = inject(NgbModal);
	closeResult = '';
  ngbModalOptions: NgbModalOptions = {
    backdrop : 'static',
    keyboard : false
};
  open(content: any) {

    this.user=sessionStorage.getItem('user');
    this.user=JSON.parse(this.user)
    this.modalService.open(content, this.ngbModalOptions).result.then((result) => {
      if (result === 'Save click') {
        this.saveUserInfo();
        this.userUpdated.emit(this.user)

      }
      else{



      }
    },
			(reason) => {
      },
		);
	}

	private getDismissReason(reason: any): string {
    switch (reason) {
      case ModalDismissReasons.ESC:
        return 'by pressing ESC';
        case ModalDismissReasons.BACKDROP_CLICK:
          return 'by clicking on a backdrop';
          default:
            return `with: ${reason}`;
          }
        }


        saveUserInfo() {
         this.http.post("http://localhost:8081/user/updateuser",this.user).subscribe(
          (response:any)=>{
            console.log(response);


          },
          (error:any)=>{
            console.log(error);

          }
         )
        }
      }

