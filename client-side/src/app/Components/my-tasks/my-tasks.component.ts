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
        const index = this.myTasks.findIndex(task=>task.id == id)

        //if there was no match the index will return a -1
        if(index!==-1){
          //set the object at at index x to the data
          this.myTasks[index]=data
        }
      },
      error:(error:ErrorEvent)=>{
        console.log(error.message)
        this.statusError = true
  
      }
    })
    
  }

  setToPending(id: number, value: string):Task {
    throw new Error('Method not implemented.');
    }

  
  

}
