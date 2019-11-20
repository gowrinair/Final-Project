import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Vendors } from '../vendors';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {
  login=new Vendors();
  logins:Vendors[];

  constructor(private Service:LoginService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params=>this.getVendorById(params['vendorId']));
  }


  update(vendor:Vendors):void{
    this.Service.updateVendor(this.login).subscribe((response)=>{
      console.log(response);
      this.router.navigate(['view']);
    },(error)=>{
      console.log(error);
    });
  }


  getVendorById(vendorId:number){
    console.log(vendorId);
    this.Service.getVendorById(vendorId).subscribe((searchData)=>{
      this.login=searchData;
      console.log(searchData);

    },(error)=>{
      console.log(error);
    });
  }

}
