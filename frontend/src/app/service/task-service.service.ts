import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Task } from '../model/task';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/tasks';
  }

  public findAll(): Observable<Task[]> {
    return this.http.get<Task[]>(this.url);
  }

  public save(task: Task) {
    return this.http.post<Task>(this.url, task);
  }
}