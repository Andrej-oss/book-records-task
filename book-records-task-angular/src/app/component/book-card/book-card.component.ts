import {Component, Input, OnInit} from '@angular/core';
import {Book, BookImpl} from "../../models/Book";
import {ApiURl} from "../../Config";

@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.css']
})
export class BookCardComponent implements OnInit {
@Input() book: Book = new BookImpl();
bookUrl: string = ApiURl.bookUrl;
  constructor() { }

  ngOnInit(): void {
  }

}
