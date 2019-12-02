import {Component, Injectable, OnInit, ViewChild} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {MatSort, MatTableDataSource, MatTableModule} from '@angular/material';
import {Observable} from 'rxjs';
import {Vehicle} from '../../vehicle';


@Component({
  selector: 'app-vehicles-list',
  templateUrl: './vehicles-list.component.html',
  styleUrls: ['./vehicles-list.component.css']
})
export class VehiclesListComponent implements OnInit {
  constructor(private http: HttpClient) {}
  private dataSource: any;
  vehicles: any;
  displayedColumns: string[] = ['plateNumber', 'Make', 'Model', 'Speed', 'seatCapacity', 'numOfDoors', 'airCondition', 'automatic'];
  readonly ROOT_URL = 'http://localhost:7070';
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  getVehicles() {
    return this.vehicles = this.http.get<Vehicle[]>(this.ROOT_URL + '/findAllVehicles');
  }
  ngOnInit() {
    this.getVehicles().subscribe(response => {
      this.vehicles = response;
      this.vehicles = new MatTableDataSource(this.vehicles);
      this.vehicles.sort = this.sort;
    });
  }

  applyFilter(filterValue: string) {
    this.vehicles.filter = filterValue.trim().toLowerCase();
  }


}
