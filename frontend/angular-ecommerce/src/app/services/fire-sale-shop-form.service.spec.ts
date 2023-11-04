import { TestBed } from '@angular/core/testing';

import { FireSaleShopFormService } from './fire-sale-shop-form.service';

describe('FireSaleShopFormService', () => {
  let service: FireSaleShopFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FireSaleShopFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
