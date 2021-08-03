import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../../models/Book";
import {ApiURl, BookUrl} from "../../Config";

@Injectable({
  providedIn: 'root'
})
export class BookDaoService {
  private urlBook = ApiURl.bookUrl;

  constructor(private httpClient: HttpClient) { }
  getAllBooks(): Observable<Book[]>{
    return this.httpClient.get<Book[]>(this.urlBook);
  }
  getOneBook(id: number): Observable<Book>{
    return this.httpClient.get<Book>(this.urlBook + `/${id}`);
  }
  saveBook(book: FormData, append: void): Observable<Book>{
    return this.httpClient.post<Book>(this.urlBook, book)
  }

}
