
import { HttpClient } from '@angular/common/http';
import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';

@Component({
  selector: 'app-customertable',
  templateUrl: './customertable.component.html',
  styleUrl: './customertable.component.css'
})
export class CustomertableComponent implements AfterViewInit {

  baseUrl: any = "http://localhost:8081";

  displayedColumns: string[] = [ 'fullname', 'email', 'contactno', 'age', 'username', 'gender', 'address', 'city', 'country'];
  //dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
  dataSource = new MatTableDataSource<PeriodicElement>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private http: HttpClient) { }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.getDataFromBackend();
  }

  getDataFromBackend() {
    this.http.get<PeriodicElement[]>(`${this.baseUrl}/user/getAllCustomers`).subscribe(
      (data) => {
        this.dataSource.data = data;
      },
      (error) => {
        console.log('Error fetching data from backend:', error);
      }
    );
  }

}


export interface PeriodicElement {
  firstname: string;
  lastname:string;
  email:string;
  contactno:number;
  age:number;
  username:string;
  gender:string;

  address:Address;
}

export interface Address {
  street:string;
  landMark:string;
  city:string;
  country:string;
  pincode:string;
}

/*
const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Manoj Modhale', age: 1.0079, gender: 'H',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 2, name: 'Helium', age: 4.0026, gender: 'He',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 3, name: 'Lithium', age: 6.941, gender: 'Li',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'England'},
  {position: 4, name: 'Beryllium', age: 9.0122, gender: 'Be',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 5, name: 'Boron', age: 10.811, gender: 'B',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'US'},
  {position: 6, name: 'Carbon', age: 12.0107, gender: 'C',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 7, name: 'Nitrogen', age: 14.0067, gender: 'N',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 8, name: 'Oxygen', age: 15.9994, gender: 'O',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 9, name: 'Fluorine', age: 18.9984, gender: 'F',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 10, name: 'Neon', age: 20.1797, gender: 'Ne',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 11, name: 'Sodium', age: 22.9897, gender: 'Na',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'Canada'},
  {position: 12, name: 'Magnesium', age: 24.305, gender: 'Mg',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 13, name: 'Aluminum', age: 26.9815, gender: 'Al',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 14, name: 'Silicon', age: 28.0855, gender: 'Si',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'China'},
  {position: 15, name: 'Phosphorus', age: 30.9738, gender: 'P',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 16, name: 'Sulfur', age: 32.065, gender: 'S',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 17, name: 'Chlorine', age: 35.453, gender: 'Cl',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 18, name: 'Argon', age: 39.948, gender: 'Ar',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 19, name: 'Potassium', age: 39.0983, gender: 'K',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
  {position: 20, name: 'Calcium', age: 40.078, gender: 'Ca',contactno: 9876543210, email: 'abc@gmail.com', username: 'abc',street: 'kothrud', address: 'Pune 411037', country: 'India'},
];
*/

