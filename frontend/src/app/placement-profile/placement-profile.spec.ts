import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlacementProfile } from './placement-profile';

describe('PlacementProfile', () => {
  let component: PlacementProfile;
  let fixture: ComponentFixture<PlacementProfile>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlacementProfile]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlacementProfile);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
