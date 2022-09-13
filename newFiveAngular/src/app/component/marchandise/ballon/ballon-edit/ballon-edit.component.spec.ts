import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BallonEditComponent } from './ballon-edit.component';

describe('BallonEditComponent', () => {
  let component: BallonEditComponent;
  let fixture: ComponentFixture<BallonEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BallonEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BallonEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
