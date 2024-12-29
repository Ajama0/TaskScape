import { Component, OnInit } from '@angular/core';
import { TaskService } from '../Service/api/task.service';
import { Task } from '../Service/api/Models/Task';

@Component({
  selector: 'app-forms',
  imports: [],
  templateUrl: './forms.component.html',
  styleUrl: './forms.component.css'
})
export class FormsComponent {
  
  title:string = ""
  description:string = ""
  date : Date = new Date()
  priority:string = ""

  task:Task = []
  postResponse:any

  constructor(private taskService:TaskService){
    //allows us to use the functionality of the service and make a request to the backend for task creation
  
   }



onSubmit():void{
  this.task = {
    "title" : this.title,
    "description": this.description,
    "date" : this.date,
    "priority" : this.priority

  }

  //instead of logging, we would like the response to be a variable and we retrieve this an input
  this.taskService.createTasks(this.task).subscribe({
    next:(data)=>{
      console.log(data)
    }
  })

  
}

}
