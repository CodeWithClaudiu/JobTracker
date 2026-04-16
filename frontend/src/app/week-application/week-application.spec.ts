import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeekApplication } from './week-application';

describe('WeekApplication', () => {
  let component: WeekApplication;
  let fixture: ComponentFixture<WeekApplication>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WeekApplication]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WeekApplication);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
