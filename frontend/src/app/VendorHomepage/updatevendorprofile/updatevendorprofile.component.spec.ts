import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatevendorprofileComponent } from './updatevendorprofile.component';

describe('UpdatevendorprofileComponent', () => {
  let component: UpdatevendorprofileComponent;
  let fixture: ComponentFixture<UpdatevendorprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdatevendorprofileComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdatevendorprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
