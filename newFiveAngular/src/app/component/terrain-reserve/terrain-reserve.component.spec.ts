import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TerrainReserveComponent } from './terrain-reserve.component';

describe('TerrainReserveComponent', () => {
  let component: TerrainReserveComponent;
  let fixture: ComponentFixture<TerrainReserveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TerrainReserveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TerrainReserveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
