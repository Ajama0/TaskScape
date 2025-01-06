import { HttpClient, HttpStatusCode } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from '../../../Models/Task';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TaskService {
 

  BASE_URL: string = "http://localhost:8097/api/v1/Tasks";

  constructor(private http: HttpClient) { }


  createTasks(task:Task):Observable<Task>{
    //we want to send a post request to the server with the parameter, which is the payload that will be binded to the requestbody
    //the post request takes 2 params (url, body=<T>)
    const createEndpoint:string  = `${this.BASE_URL}/create`
    return this.http.post<Task>(createEndpoint, task)
  }


  //the return type from the server includes a status and therfore wont be of type task
  findTasks():Observable<Task[]>{
    const findAllUrl:string = `${this.BASE_URL}/my-tasks`
    return this.http.get<Task[]>(findAllUrl)
}

  updateToCompleted(id:number, value:string):Observable<Task>{
    //define the endpoint to be sent to the server and bind the request parameter which is value
    const updateStatusPath:string = `${this.BASE_URL}/update/status?id=${id}&value=${value}`
    return this.http.put<Task>(updateStatusPath, null)

  }


  updateToPending(id: number, value: string):Observable<Task> {
    const pendingStatusURL = `${this.BASE_URL}/update/status/c?id=${id}&id2=${value}`
    //return null in the put request as no requestbody will be sent to the server
    return this.http.put<Task>(pendingStatusURL,null)
  }
  
  //best practices are to exclude a response body for a delete request, thus return nothing. 
  deleteTask(id:number):Observable<void>{
    const deleteTaskUrl = `${this.BASE_URL}/delete/${id}`
    return this.http.delete<void>(deleteTaskUrl)

  }

}
