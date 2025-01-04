import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatedelieveryprofileComponent } from './updatedelieveryprofile.component';

describe('UpdatedelieveryprofileComponent', () => {
  let component: UpdatedelieveryprofileComponent;
  let fixture: ComponentFixture<UpdatedelieveryprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdatedelieveryprofileComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdatedelieveryprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
