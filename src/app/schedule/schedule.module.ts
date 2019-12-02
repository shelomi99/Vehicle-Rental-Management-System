import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ScheduleRoutingModule } from './schedule-routing.module';
import { ScheduleListComponent } from './schedule-list/schedule-list.component';

// Material
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatStepperModule} from '@angular/material/stepper';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatTabsModule} from '@angular/material/tabs';
import {MatMomentDateModule} from '@angular/material-moment-adapter';
import {MatIconModule} from '@angular/material/icon';
import { CarListComponent } from './schedule-list/car-list/car-list.component';
import { VanListComponent } from './schedule-list/van-list/van-list.component';
import { MotorbikeListComponent } from './schedule-list/motorbike-list/motorbike-list.component';


@NgModule({
  declarations: [ScheduleListComponent, CarListComponent, VanListComponent, MotorbikeListComponent],
  imports: [
    CommonModule,
    ScheduleRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    // Material
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatTabsModule,
    MatStepperModule,
    MatAutocompleteModule,
    MatIconModule,
    MatDatepickerModule,
    MatMomentDateModule
  ]
})
export class ScheduleModule { }
