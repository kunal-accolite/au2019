import { TestBed } from '@angular/core/testing';

import { AssingmentServiceService } from './assingment-service.service';

describe('AssingmentServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AssingmentServiceService = TestBed.get(AssingmentServiceService);
    expect(service).toBeTruthy();
  });
});
