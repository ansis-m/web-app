import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Response} from "../../models/response";

@Injectable({
  providedIn: 'root'
})
export class TestService {
  private response: string = "FAILURE";

  constructor(private http: HttpClient) { }

  testConnection(message: string): Observable<Response> {
    console.log(message);
    return this.http.get<Response>("http://localhost:8081/test", {observe: 'body', responseType: 'json'});
  }
}
