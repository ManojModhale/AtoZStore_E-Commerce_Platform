import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-productinfo',
  templateUrl: './productinfo.component.html',
  styleUrl: './productinfo.component.css'
})
export class ProductinfoComponent {

  @Input() product:any;
disc: any;

}
