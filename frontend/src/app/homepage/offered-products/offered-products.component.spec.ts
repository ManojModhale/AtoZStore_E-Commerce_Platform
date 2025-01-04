import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferedProductsComponent } from './offered-products.component';

describe('OfferedProductsComponent', () => {
  let component: OfferedProductsComponent;
  let fixture: ComponentFixture<OfferedProductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OfferedProductsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OfferedProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
