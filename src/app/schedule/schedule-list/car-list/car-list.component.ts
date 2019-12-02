import { Component, OnInit } from '@angular/core';
import {EmailValidator, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormControl} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Car} from '../../../car';
import {Customer} from '../../customer.model';
import {Schedule} from '../../schedule.model';
import {ServiceService} from '../../service.service';


@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
  firstFormGroup: FormGroup;
  minDate = new Date();
  // tslint:disable-next-line:new-parens
  dateCtrl = new FormControl(new Date);
  myControl = new FormControl();

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private service: ServiceService) {
  }

  readonly ROOT_URL = 'http://localhost:7070';
  cars: Observable<Car[]>;
  customer: Customer = new Customer();
  schedule: Schedule = new Schedule();

  getCars() {
    this.cars = this.http.get<Car[]>(this.ROOT_URL + '/findAllCars');
  }
  ngOnInit() {
    this.dateCtrl = new FormControl('', [Validators.required]);
    this.firstFormGroup = this.formBuilder.group({
      emailCtrl: ['', Validators.required],
      priorityCtrl: ['', Validators.required],
    });
    this.getCars();
  }
  submit() {
    this.schedule.customer = this.customer;
    this.service.createSchedule(this.schedule).subscribe();
  }

}

