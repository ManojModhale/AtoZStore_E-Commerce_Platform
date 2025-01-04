import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html',
  styleUrls: ['./paginator.component.css']
})
export class PaginatorComponent {
  @Input() pageSizeOptions: number[] = [5, 10, 20];
  @Input() pageSize!: number;
  @Input() collectionSize!: number;
  @Output() pageChange = new EventEmitter<number>();
  @Input() currentPage!: number;
}
