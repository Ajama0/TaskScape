import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../Service/api/task.service';
import { Task } from '../../Service/api/Models/Task';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-my-tasks',
  imports: [CommonModule],
  templateUrl: './my-tasks.component.html',
  styleUrl: './my-tasks.component.css'
})
export class MyTasksComponent implements OnInit{

  myTasks: Array<Task> = []



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

  
  

}
