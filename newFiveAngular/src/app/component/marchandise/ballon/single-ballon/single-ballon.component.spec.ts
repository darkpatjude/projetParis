import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleBallonComponent } from './single-ballon.component';

describe('SingleBallonComponent', () => {
  let component: SingleBallonComponent;
  let fixture: ComponentFixture<SingleBallonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SingleBallonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SingleBallonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
