import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewComponent } from './view/view.component';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';


const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'view',component:ViewComponent},
  {path:'add',component:AddComponent},
  {path:'edit/:vendorId',component:EditComponent},
  {path:'api/getVenderByid/:vendorId',component:EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
