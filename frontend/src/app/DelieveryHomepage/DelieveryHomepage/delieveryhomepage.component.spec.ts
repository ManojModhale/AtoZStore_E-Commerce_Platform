import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelieveryhomepageComponent } from './delieveryhomepage.component';

describe('DelieveryhomepageComponent', () => {
  let component: DelieveryhomepageComponent;
  let fixture: ComponentFixture<DelieveryhomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DelieveryhomepageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DelieveryhomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
