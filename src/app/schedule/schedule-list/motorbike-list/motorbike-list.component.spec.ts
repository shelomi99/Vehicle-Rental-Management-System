import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MotorbikeListComponent } from './motorbike-list.component';

describe('MotorbikeListComponent', () => {
  let component: MotorbikeListComponent;
  let fixture: ComponentFixture<MotorbikeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MotorbikeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MotorbikeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
