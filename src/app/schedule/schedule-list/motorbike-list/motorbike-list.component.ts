import { Component, OnInit } from '@angular/core';
import {EmailValidator, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {Vehicle} from '../../../vehicle';
import {HttpClient} from '@angular/common/http';
import {Bike} from '../../../bike';
import {Customer} from '../../customer.model';
import {Schedule} from '../../schedule.model';
import {ServiceService} from '../../service.service';

@Component({
  selector: 'app-motorbike-list',
  templateUrl: './motorbike-list.component.html',
  styleUrls: ['./motorbike-list.component.css']
})
export class MotorbikeListComponent implements OnInit {
  firstFormGroup: FormGroup;
  minDate = new Date();
  // tslint:disable-next-line:new-parens
  dateCtrl = new FormControl(new Date);
  myControl = new FormControl();
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private service: ServiceService) {}
  readonly ROOT_URL = 'http://localhost:7070';
  bikes: Observable<Bike[]>;
  customer: Customer = new Customer();
  schedule: Schedule = new Schedule();
  getBikes() {
    this.bikes = this.http.get<Bike[]>(this.ROOT_URL + '/findAllBikes');
  }

  ngOnInit() {
    this.dateCtrl = new FormControl('', [Validators.required]);
    this.firstFormGroup = this.formBuilder.group({
      emailCtrl: ['', Validators.required],
      priorityCtrl: ['', Validators.required],
      myControl : ['', Validators.required],
    });
    this.getBikes();
  }
  submit() {
    this.schedule.customer = this.customer;
    this.service.createSchedule(this.schedule).subscribe();
  }

}

