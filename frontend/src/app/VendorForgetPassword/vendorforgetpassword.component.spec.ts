import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorforgetpasswordComponent } from './vendorforgetpassword.component';

describe('VendorforgetpasswordComponent', () => {
  let component: VendorforgetpasswordComponent;
  let fixture: ComponentFixture<VendorforgetpasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VendorforgetpasswordComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VendorforgetpasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
