import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelieveryprofileComponent } from './delieveryprofile.component';

describe('DelieveryprofileComponent', () => {
  let component: DelieveryprofileComponent;
  let fixture: ComponentFixture<DelieveryprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DelieveryprofileComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DelieveryprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
