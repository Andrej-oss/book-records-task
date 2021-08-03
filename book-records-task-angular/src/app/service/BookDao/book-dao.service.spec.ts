import { TestBed } from '@angular/core/testing';

import { BookDaoService } from './book-dao.service';

describe('BookDaoService', () => {
  let service: BookDaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookDaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
