import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelieverypartnerregistrationComponent } from './delieverypartnerregistration.component';

describe('DelieverypartnerregistrationComponent', () => {
  let component: DelieverypartnerregistrationComponent;
  let fixture: ComponentFixture<DelieverypartnerregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DelieverypartnerregistrationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DelieverypartnerregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
