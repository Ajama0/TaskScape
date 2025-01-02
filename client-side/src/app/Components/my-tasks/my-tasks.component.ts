import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../Service/api/task.service';
import { Task } from '../../Service/api/Models/Task';
import { CommonModule } from '@angular/common';
import { delay } from 'rxjs';

@Component({
  selector: 'app-my-tasks',
  imports: [CommonModule],
  templateUrl: './my-tasks.component.html',
  styleUrl: './my-tasks.component.css'
})
export class MyTasksComponent implements OnInit{

  myTasks: Array<Task> = []
  statusError:Boolean = false
  
  constructor(private taskService:TaskService){}
 
  ngOnInit(): void {
  //we essentially as soon as this component is rendered, we want to fetch all tasks
  //this component will be rendered from a redirect or from a client clicking my-tasks
  this.fetchTasks()

  }


  fetchTasks():void{
    this.taskService.findTasks().subscribe({
      next:(data)=>{
        console.log("Tasks fetched successfully", data)
        this.myTasks = data
        
      },
  
      error:(error:ErrorEvent)=>{
        console.log("There was error fetching the tasks", error.message)
      }
  
    });
  }

  setToCompleted(id:number, value:string):void{
    //now the user has trigged the event of setting the task to pending- we assume a task is still not finished
    //we can call the service class with the parameters of the current task instance and the query param (new value)

    this.taskService.updateToCompleted(id, value).subscribe({
      next:(data:Task)=>{
        console.log(data)
        this.fetchTasks()
        
      },
      error:(error:ErrorEvent)=>{
        console.log(error.message)
        this.statusError = true
  
      }
    })
    
  }

  setToPending(id: number, value: string):void {
    //call the service class function and pass in the values from the DOM

    this.taskService.updateToPending(id,value).subscribe({
      next:(updatedTask:Task)=>{
         console.log(updatedTask)
        //http request to prevent local state update and to fetch updated data from the server
        this.fetchTasks()

      },
      error:(error:ErrorEvent)=>{
        console.log(error.message)
      }
    })
    }

  
  

}

