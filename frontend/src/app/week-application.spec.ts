import { TestBed } from '@angular/core/testing';

import { WeekApplication } from './week-application';

describe('WeekApplication', () => {
  let service: WeekApplication;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WeekApplication);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
