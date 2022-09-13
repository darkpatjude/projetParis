import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaillotEditComponent } from './maillot-edit.component';

describe('MaillotEditComponent', () => {
  let component: MaillotEditComponent;
  let fixture: ComponentFixture<MaillotEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaillotEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MaillotEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
