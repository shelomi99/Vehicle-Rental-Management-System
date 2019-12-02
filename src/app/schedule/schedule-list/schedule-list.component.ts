import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-schedule-list',
  templateUrl: './schedule-list.component.html',
  styleUrls: ['./schedule-list.component.css']
})
export class ScheduleListComponent implements OnInit {
  firstFormGroup: FormGroup;
minDate = new Date();
dateCtrl: FormControl;
  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.dateCtrl = new FormControl('', [Validators.required]);
    this.firstFormGroup = this.formBuilder.group({
      emailCtrl: ['', Validators.required],
      priorityCtrl: ['', Validators.required],
    });
  }
}

