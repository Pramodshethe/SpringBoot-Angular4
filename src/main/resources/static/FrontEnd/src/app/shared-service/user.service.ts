import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/observable';
import {User} from '../user';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()
export class UserService {
  private baseUrl:string='http://localhost:9000/user'; 
  private headers = new Headers( {'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});

  constructor(private _http:Http) { }

   getAllUser(){
     return this._http.get(this.baseUrl+'/findall',this.options).map((response:Response)=>response.json())
     .catch(this.errorHandler);
   
   }

   getUser(id:Number){
    return this._http.get(this.baseUrl+'/findone'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  
  }

  deleteUser(id:Number){
    return this._http.delete(this.baseUrl+'/delete'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  
  }

  saveUser(user:User){
    return this._http.post(this.baseUrl+'/save',JSON.stringify(user) ,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  
  }

   errorHandler(error:Response){

    return Observable.throw(error || "SERVER ERROR")

   }
}
