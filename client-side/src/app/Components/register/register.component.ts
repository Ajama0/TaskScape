import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Register } from '../../Models/Register';
import { Router } from '@angular/router';
import { UserService } from '../../Service/api/TaskService/UserService/user.service';

@Component({
  selector: 'app-register',
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  /**
   * because we bind the values from the input using ngmodel which allows for 2 way binding
   * angular automatically updates the instance variables
   */
  user:Register = {
  firstname: "",
  lastname : "",
  email : "",
  password : ""

  }

  /**
   * 
   * @param router - allows us the navigate to the other endpoints
   * setting access modifier to private allows the router to be a property within our ts file
   * otherwise it would remain a method parameter
   */
  constructor(private router:Router, private userService:UserService){}

  registerSubmit():string{
    /**
     * when we submit the form, we send a post request to the server
     * the backend sees the client does not have a jwt and the client doesnt have a existing account
     * hence client does not require authentication for signing up
     * We would like to return a jwt token back to the user
     */

    this.userService.register()
    

  }


  

}
