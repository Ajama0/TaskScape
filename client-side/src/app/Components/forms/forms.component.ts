import { Component, Inject, OnInit } from '@angular/core';
import { TaskService } from '../../Service/api/task.service';
import { Task } from '../../Service/api/Models/Task';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';



@Component({
  selector: 'app-forms',
  imports: [FormsModule],
  templateUrl: './forms.component.html',
  styleUrl: './forms.component.css'
})
export class FormsComponent implements OnInit{
  
  title:string = ""
  description:string = ""
  date : Date = new Date()
  priority:string = ""
  
  //this will be a boolean check that will be set to false whenever the client sends a request to update the status
  isPending:Boolean = false
  

  
  task:Task | null = null

  constructor(private taskService:TaskService, 
    private router:Router){
    //allows us to use the functionality of the service and make a request to the backend for task creation
   }
  ngOnInit(): void {
  }


onSubmit():void{
  //when we submit the button, we bind the input to the instance variables associated to the current instance component
  this.task = {
    "title": this.title,
    "description": this.description,
    "date" : this.date,
    "priority" : this.priority
  }



  //instead of logging, we would like the response to be a variable and we retrieve this an input
  this.taskService.createTasks(this.task).subscribe({
    next:(data)=>{

    
    //best practice is to return the Id of the post request  
    console.log("Task created Successfully!" , data)
    //whenever the user submits a form, we can set the isPending to true
    this.isPending = true
    
    //add a pop up button
    //allow the user to click yes or no for going to see their tasks

      //would you like to see your tasks
      //button yes or no, if no stay redirect them to the homepage, if yes redirect them to tasks
      //if we have submitted and the user 
      //this.router.navigate(["my-tasks"])
    },
    error:(error:ErrorEvent)=>{
      console.log(error.message)
    }
    
  });

  
}

}
