import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from '../service/task-service.service';
import { Task } from '../model/task';

@Component({
  selector: 'app-user-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class UserFormComponent {

  task: Task;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private taskService: TaskService) {
    this.task = new Task(1, "", "", new Date());
  }

  onSubmit() {
    this.taskService.save(this.task).subscribe(result => this.gotoTaskList());
  }

  gotoTaskList() {
    this.router.navigate(['/tasks']);
  }
}