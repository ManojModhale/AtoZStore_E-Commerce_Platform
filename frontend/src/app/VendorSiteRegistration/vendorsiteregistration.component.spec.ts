import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorsiteregistrationComponent } from './vendorsiteregistration.component';

describe('VendorsiteregistrationComponent', () => {
  let component: VendorsiteregistrationComponent;
  let fixture: ComponentFixture<VendorsiteregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VendorsiteregistrationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VendorsiteregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
