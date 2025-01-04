import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelieveryboydetailsComponent } from './delieveryboydetails.component';

describe('DelieveryboydetailsComponent', () => {
  let component: DelieveryboydetailsComponent;
  let fixture: ComponentFixture<DelieveryboydetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DelieveryboydetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DelieveryboydetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
