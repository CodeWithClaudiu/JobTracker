import { TestBed } from '@angular/core/testing';

import { PlacementProfile } from './placement-profile';

describe('PlacementProfile', () => {
  let service: PlacementProfile;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlacementProfile);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
