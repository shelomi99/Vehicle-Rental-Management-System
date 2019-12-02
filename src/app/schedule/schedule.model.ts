import {Customer} from './customer.model';

export class Schedule {
  pickUpDate: string;
  dropOffDate: string;
  vehiclePlateNo: string;
  customer: Customer;
}
