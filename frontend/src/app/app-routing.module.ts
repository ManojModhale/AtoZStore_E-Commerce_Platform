import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SigninComponent } from './SignIn/signin.component';
import { LoginComponent } from './Login/login.component';
import { WelcomepageComponent } from './WelcomePage/welcomepage.component';
import { HomepageComponent } from './homepage/homepage.component';
import { CategoriesComponent } from './homepage/categories/categories.component';
import { ProductcategoryComponent } from './homepage/productcategory/productcategory.component';
import { ProfileComponent } from './profile/profile.component';

// import { WelcomepageComponent } from './WelcomePage/welcomepage.component';

import { NotfoundComponent } from './NotfoundPage/notfound.component';
import { ChangePasswordComponent } from './ForgotPassword/change-password.component';
import { CartpageComponent } from './CartPage/cartpage.component';
import { LogoutComponent } from './Logout/logout.component';
import { ProductsummaryComponent } from './Productsummary/productsummary.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { AddimageComponent } from './addimage/addimage.component';
import { VendorsiteregistrationComponent } from './VendorSiteRegistration/vendorsiteregistration.component';
import { DelieverypartnerregistrationComponent } from './DelieveryPartnerRegistration/delieverypartnerregistration.component';
import { VendorhomepageComponent } from './VendorHomepage/vendorhomepage.component';
import { SearchproductComponent } from './homepage/searchproduct/searchproduct.component';
import { DelieveryboydetailsComponent } from './DelieveryHomepage/DelieveryHomepage/delieveryboydetails/delieveryboydetails.component';
import { DelieveryhomepageComponent } from './DelieveryHomepage/DelieveryHomepage/delieveryhomepage.component';
import { VendorprofileComponent } from './VendorHomepage/vendorprofile/vendorprofile.component';
import { VendordetailsComponent } from './VendorHomepage/vendordetails/vendordetails.component';
import { OrderhistoryComponent } from './Order_History/orderhistory.component';
import { DelieveryprofileComponent } from './DelieveryHomepage/DelieveryHomepage/delieveryprofile/delieveryprofile.component';
import { VendorforgetpasswordComponent } from './VendorForgetPassword/vendorforgetpassword.component';
import { DelieveryforgetpasswordComponent } from './DelieveryForgetPassword/delieveryforgetpassword.component';
import { AdminloginComponent } from './Admin/Admin_Login/adminlogin.component';
import { DashboardComponent } from './Admin/Dashboard/dashboard.component';

const routes: Routes = [
  { path: '', component: WelcomepageComponent },
  {path:'adminlogin', component: AdminloginComponent},
  {path:'dashboard',component:DashboardComponent},
  { path: 'signin', component: SigninComponent },
  { path: 'forgotpassword', component: ChangePasswordComponent},
  { path: 'login', component: LoginComponent },
  { path: 'vendorsignup', component: VendorsiteregistrationComponent },
  { path: 'delieverysignup', component: DelieverypartnerregistrationComponent },
  { path: 'vendorforgotpassword', component: VendorforgetpasswordComponent},
   { path: 'delieveryforgotpassword', component: DelieveryforgetpasswordComponent},



  


  {path:"home",component:HomepageComponent,
  children:[
    {path:"",component:CategoriesComponent},
    {path:"profile",component:ProfileComponent},
    { path: 'products/:category', component: ProductcategoryComponent },
    { path: 'logout', component: LogoutComponent },
    { path: 'cart', component: CartpageComponent },
    { path: 'cart/checkout', component: ProductsummaryComponent},
    { path: 'searchproduct/:searchpro', component: SearchproductComponent},
    {path: 'orderHistory',component:OrderhistoryComponent},

  ]
  },
  {path:"vendor",component:VendorhomepageComponent,
  children:[
    {path:"",component:VendordetailsComponent},
    { path: 'addproduct', component: AddproductComponent},
  { path: 'addimage', component: AddimageComponent},

    {path:"vendorprofile",component:VendorprofileComponent},

    { path: 'addproduct', component: AddproductComponent}

  ]
},


{path:"delieveryhome",component:DelieveryhomepageComponent,
  children:[
    {path:"",component:DelieveryboydetailsComponent},
    {path:"delieveryprofile",component:DelieveryprofileComponent},



  ]
},
  { path: '**', component: NotfoundComponent}


];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
