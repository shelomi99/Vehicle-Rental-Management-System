import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpClientModule} from '@angular/common/http';

import { VehiclesRoutingModule } from './vehicles-routing.module';
import { VehiclesListComponent } from './vehicles-list/vehicles-list.component';
import {MatFormFieldModule, MatInputModule, MatSortModule, MatTableModule} from '@angular/material';

@NgModule({
  declarations: [VehiclesListComponent],
  imports: [
    CommonModule,
    VehiclesRoutingModule,
    HttpClientModule,
    MatFormFieldModule,
    MatTableModule,
    MatSortModule,
    MatInputModule
  ]
})
export class VehiclesModule { }
