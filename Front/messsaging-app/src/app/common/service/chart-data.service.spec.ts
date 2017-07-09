import { TestBed, inject } from '@angular/core/testing';

import { ChartDataService } from './chart-data.service';

describe('PieServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChartDataService]
    });
  });

  it('should be created', inject([ChartDataService], (service: ChartDataService) => {
    expect(service).toBeTruthy();
  }));
});
