import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
  path: 'home',
  loadChildren: './home/home.module#HomeModule'
},
  {
    path: 'schedule',
    loadChildren: './schedule/schedule.module#ScheduleModule'
  },
  {
    path: 'vehicles',
    loadChildren: './vehicles/vehicles.module#VehiclesModule'
  },
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  },

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule ]
})
export class AppRoutingModule {}
