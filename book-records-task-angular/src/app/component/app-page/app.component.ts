import { Component } from '@angular/core';
import {BookDaoService} from "../../service/BookDao/book-dao.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'book-records-task-angular';
  constructor(private bookDaoService: BookDaoService) {
  }
}
