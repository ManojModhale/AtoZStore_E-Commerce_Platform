import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorhomepageComponent } from './vendorhomepage.component';

describe('VendorhomepageComponent', () => {
  let component: VendorhomepageComponent;
  let fixture: ComponentFixture<VendorhomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VendorhomepageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VendorhomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
