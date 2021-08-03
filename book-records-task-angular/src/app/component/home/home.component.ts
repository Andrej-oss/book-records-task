import {Component, Input, OnInit} from '@angular/core';
import {BookDaoService} from "../../service/BookDao/book-dao.service";
import {Book, BookImpl} from "../../models/Book";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookDaoService: BookDaoService) { }

  ngOnInit(): void {
    this.bookDaoService.getAllBooks().subscribe(books => this.books = books);
  }

}
