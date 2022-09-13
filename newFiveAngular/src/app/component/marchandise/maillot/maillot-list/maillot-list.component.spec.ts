import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaillotListComponent } from './maillot-list.component';

describe('MaillotListComponent', () => {
  let component: MaillotListComponent;
  let fixture: ComponentFixture<MaillotListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaillotListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MaillotListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
