

export class Response{
  response: string;
  status: string;

  constructor(response: string, status: string) {
    this.status = status;
    this.response = response;
  }
}
