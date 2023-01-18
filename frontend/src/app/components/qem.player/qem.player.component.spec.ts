import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QemPlayerComponent } from './qem.player.component';

describe('QemPlayerComponent', () => {
  let component: QemPlayerComponent;
  let fixture: ComponentFixture<QemPlayerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QemPlayerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QemPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
