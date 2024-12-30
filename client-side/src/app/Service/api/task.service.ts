import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from './Models/Task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }



  createTasks(task:Task):Observable<Task>{
    //we want to send a post request to the server with the parameter, which is the payload that will be binded to the requestbody
    //the post request takes 2 params (url, body=<T>)
    return this.http.post<Task>("", task)
  }
}
