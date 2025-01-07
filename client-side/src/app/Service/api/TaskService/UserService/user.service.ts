import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Register } from '../../../../Models/Register';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  BASE_URL: string = "http://localhost:8097/api/v1/Auth";

  constructor(private http:HttpClient) { 
  }


  public register(user:Register):Observable<string>{
    /**
     * this allows us to authenticate the user
     * the user will recieve a jwt token in which will be used in the authorization header of subsequent requests
     * 
     */
    const registerEndpoint:string = `${this.BASE_URL}/register`
    return this.http.post<string>(registerEndpoint,user)



  }





}
