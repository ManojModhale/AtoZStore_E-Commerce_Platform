import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelieveryforgetpasswordComponent } from './delieveryforgetpassword.component';

describe('DelieveryforgetpasswordComponent', () => {
  let component: DelieveryforgetpasswordComponent;
  let fixture: ComponentFixture<DelieveryforgetpasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DelieveryforgetpasswordComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DelieveryforgetpasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
