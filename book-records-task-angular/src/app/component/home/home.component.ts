import {Component, Input, OnInit} from '@angular/core';
import {BookDaoService} from "../../service/BookDao/book-dao.service";
import {Book, BookImpl} from "../../models/Book";
import {catchError} from "rxjs/operators";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  books: Book[] = [];
  error: string = '';
  constructor(private bookDaoService: BookDaoService) { }

  ngOnInit(): void {
    this.bookDaoService.getAllBooks().subscribe(books => this.books = books,
        catchError(error => this.error = error));
  }

}
