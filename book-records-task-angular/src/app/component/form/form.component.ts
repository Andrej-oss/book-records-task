import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Book, BookImpl} from "../../models/Book";
import {BookDaoService} from "../../service/BookDao/book-dao.service";
import {Router} from "@angular/router";
import {catchError} from "rxjs/operators";
import {ErrorImpl} from "../../models/Error";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  book: Book = new BookImpl();
  formBook: FormGroup;
  title: FormControl;
  author: FormControl;
  isbn: FormControl;
  image: File = new File([new Blob()], 'file');
  formData: FormData = new FormData();
  error: ErrorImpl = new ErrorImpl();

  constructor(private bookDaoService: BookDaoService, private router: Router) {
    this.formBook = new FormGroup({
      title: this.title = new FormControl('', [Validators.required]),
      author: this.author = new FormControl('', [Validators.required]),
      isbn: this.isbn = new FormControl('', [Validators.required, Validators.pattern(/[0-9]/gi)])
    });
  }

  ngOnInit(): void {
  }

  onSubmit(formBook: FormGroup) {
    this.formData.append('title', formBook.controls.title.value);
    this.formData.append('author', formBook.controls.author.value);
    this.formData.append('ISBN', formBook.controls.isbn.value);
    this.bookDaoService.saveBook(this.formData, this.formData.append('image', this.image)).subscribe(book =>
    {
      this.book = book;
      this.resetForm();
    },
        (e: any) => {
          this.error = e.error
        });
  }

  myUploader(file: any) {
    this.image = file.files[0];
  }
  resetForm(): void{
    this.formBook.reset();
    this.formData.delete('title');
    this.formData.delete('author');
    this.formData.delete('ISBN');
    this.formData.delete('image');
    this.router.navigate(['/home']);
  }
}
