import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Output, inject } from '@angular/core';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal, NgbModalOptions } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-updatevendorprofile',
  templateUrl: './updatevendorprofile.component.html',
  styleUrl: './updatevendorprofile.component.css'
})
export class UpdatevendorprofileComponent {
  @Output() vendorUpdated = new EventEmitter<any>();
  vendor!:any;

   constructor(private http:HttpClient,private router:Router){


   }

   private modalService = inject(NgbModal);
   closeResult = '';
   ngbModalOptions: NgbModalOptions = {
    backdrop : 'static',
    keyboard : false,
    
};

   open(content: any) {

     this.vendor=sessionStorage.getItem('vendor');
     this.vendor=JSON.parse(this.vendor)
     this.modalService.open(content, this.ngbModalOptions).result.then((result) => {
       if (result === 'Save click') {
         this.saveUserInfo();
         this.vendorUpdated.emit(this.vendor)

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
          this.http.post("http://localhost:8081/vendor/update",this.vendor).subscribe(
           (response:any)=>{
             console.log(response);


           },
           (error:any)=>{
             console.log(error);

           }
          )
         }
}
