import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleMaillotComponent } from './single-maillot.component';

describe('SingleMaillotComponent', () => {
  let component: SingleMaillotComponent;
  let fixture: ComponentFixture<SingleMaillotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SingleMaillotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SingleMaillotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
