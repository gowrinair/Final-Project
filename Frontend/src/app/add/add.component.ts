import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';
import { Vendors } from '../vendors';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  vendor = new Vendors();


  constructor(private Service:LoginService,private router:Router) { }

  ngOnInit() {
    this.vendor.vStatus="yes";
   // this.addVendors();
    
  }


  addVendors(): void{
 
    this.Service.addVendor(this.vendor)
      .subscribe((response)=>{ 
        console.log(response);
        
        
      }, (error)=>{

        console.log(error);
      });
      this.router.navigate(['view']);
  }

  goback():void{
    this.router.navigate(['/view']);
  }




  


}
