import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';
import { Vendors } from '../vendors';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {
  vendors: Vendors[];
  vendor = new Vendors();

  search:string;

  constructor(private Service:LoginService, private router:Router) { }

  ngOnInit() {
    this.vendor.vStatus="yes";
    this.getVendors();
  }


  getVendors(): void {
    this.Service.getAllVendors().subscribe((data) => {
       this.vendors = data,
        console.log(data); },
         (error) => { console.log(error); });
  }


  edit(vendorId:number):void{
    console.log(vendorId);
    this.router.navigate(['api/getVenderByid/'+vendorId]);
  }

  goback():void{
    this.router.navigate(['']);
  }




  searchVendor(search:string): void{
    if(search!=null)
    {
      this.Service.searchVendor(search).subscribe((vendorData)=>{
        this.search=undefined;
        this.vendors=vendorData,
        console.log(vendorData);

      },(error)=>{
        console.log(error);
      });
    }
    else{ 
      this.getVendors();
    }
  }

   
  disableVendor(vendors: Vendors){
    console.log("Disable");
      this.Service.disableVendor(vendors)
      .subscribe((response) =>{
        this.getVendors();
      }, (error) =>{
        console.log(error);
      });
  }

  newVendors(){
    this.router.navigate(['add']);
  }
}
