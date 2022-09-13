import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BallonListComponent } from './ballon-list.component';

describe('BallonListComponent', () => {
  let component: BallonListComponent;
  let fixture: ComponentFixture<BallonListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BallonListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BallonListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
