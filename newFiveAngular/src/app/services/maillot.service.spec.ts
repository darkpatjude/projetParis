import { TestBed } from '@angular/core/testing';

import { MaillotService } from './maillot.service';

describe('MaillotService', () => {
  let service: MaillotService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MaillotService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
