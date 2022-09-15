import { TestBed } from '@angular/core/testing';

import { TerrainReserveService } from './terrain-reserve.service';

describe('TerrainReserveService', () => {
  let service: TerrainReserveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TerrainReserveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
