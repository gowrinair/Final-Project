import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vendors } from '../vendors';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  formData:Vendors

  constructor(private _httpService:HttpClient,private _router:Router) { }

  getRoleId(formData:any):any{
    return this._httpService.get<Vendors>(environment.APIUrl+'/api/login/'+formData.username+'/'+formData.password);
  }


  getAllVendors(): Observable<Vendors[]>{
    return this._httpService.get<Vendors[]>(environment.APIUrl +'/viewList');
  }

  addVendor(vendor:Vendors)
  {
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

   

     
      return this._httpService.post(environment.APIUrl +'/vendor/add',body,options);
    
  }



  updateVendor(vendor:Vendors)
  {
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

   return this._httpService.put(environment.APIUrl +'/vendor/add',body,options);
  
    

}


disableVendor(vendor: Vendors){
  let body=JSON.stringify(vendor);
  let headers=new HttpHeaders({'Content-Type':'application/json'});
  let options={headers:headers}
  return this._httpService.put(environment.APIUrl+'/disable',body,options);
}




getVendorById(vendorId:number):Observable<Vendors>{
  return this._httpService.get<Vendors>(environment.APIUrl+'/api/getVenderByid/'+vendorId)
}


searchVendor(search:string):Observable<Vendors[]>{
  return this._httpService.get<Vendors[]>(environment.APIUrl +'/search/'+search);

}

}
