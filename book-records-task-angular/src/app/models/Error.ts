export interface Error {
    status: number;
    message: string;
    tittle: string;
}
export class ErrorImpl implements Error{
    message = '';
    status = 0;
    tittle = '';

}
