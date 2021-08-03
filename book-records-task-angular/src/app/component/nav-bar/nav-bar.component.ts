import { Component, OnInit } from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  items: MenuItem[];
  activeItem: MenuItem;

  constructor() {
    this.items = [];
    this.activeItem = {};
  }

  ngOnInit(): void {
    this.items = [
      {label: 'Books', icon: 'pi pi-fw pi-home', routerLink: '/book'},
      {label: 'Form', icon: 'pi pi-fw pi-pencil', routerLink: '/form'},
    ];
  }

}
