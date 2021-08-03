export interface Book {
    id?: number,
    author: string,
    title: string,
    ISBN: number
}
export class BookImpl implements Book{
    ISBN = 0;
    author = '';
    title = '';
}
