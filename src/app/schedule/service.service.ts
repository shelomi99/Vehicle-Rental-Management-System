import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Schedule} from './schedule.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  readonly ROOT_URL = 'http://localhost:7070';
  createSchedule(scheduleClass: Schedule): Observable<Schedule> {
    return  this.http.post<Schedule>(this.ROOT_URL + '/schedule', scheduleClass);
  }
  constructor(private http: HttpClient) { }
}
