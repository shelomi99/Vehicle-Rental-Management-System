import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormControl} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Car} from '../../../car';
import {Van} from '../../../van';
import {Customer} from '../../customer.model';
import {Schedule} from '../../schedule.model';
import {ServiceService} from '../../service.service';

@Component({
  selector: 'app-van-list',
  templateUrl: './van-list.component.html',
  styleUrls: ['./van-list.component.css']
})
export class VanListComponent implements OnInit {
  firstFormGroup: FormGroup;
  minDate = new Date();
  myControl = new FormControl();
  // tslint:disable-next-line:new-parens
  dateCtrl = new FormControl(new Date);
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private service: ServiceService) {}
  readonly ROOT_URL = 'http://localhost:7070';
  vans: Observable<Van[]>;
  customer: Customer = new Customer();
  schedule: Schedule = new Schedule();
  getVans() {
    this.vans = this.http.get<Van[]>(this.ROOT_URL + '/findAllVans');
  }

  ngOnInit() {
    this.dateCtrl = new FormControl('', [Validators.required]);
    this.firstFormGroup = this.formBuilder.group({
      emailCtrl: ['', Validators.required],
      priorityCtrl: ['', Validators.required],
    });
    this.getVans();
  }
  submit() {
    this.schedule.customer = this.customer;
    this.service.createSchedule(this.schedule).subscribe();
  }

}

