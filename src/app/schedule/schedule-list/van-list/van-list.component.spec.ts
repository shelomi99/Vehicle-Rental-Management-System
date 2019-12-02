import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VanListComponent } from './van-list.component';

describe('VanListComponent', () => {
  let component: VanListComponent;
  let fixture: ComponentFixture<VanListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VanListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VanListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
