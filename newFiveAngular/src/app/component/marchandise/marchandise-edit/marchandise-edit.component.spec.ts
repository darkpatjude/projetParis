import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarchandiseEditComponent } from './marchandise-edit.component';

describe('MarchandiseEditComponent', () => {
  let component: MarchandiseEditComponent;
  let fixture: ComponentFixture<MarchandiseEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MarchandiseEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MarchandiseEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
