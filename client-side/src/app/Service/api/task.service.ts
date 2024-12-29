import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from './Models/Task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(Httpclient: HttpClient) { }



  createTasks(task:Task):Observable<Task>{
  }
}
