import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Response} from "../../models/response";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class TService {

  private BACKEND_URL: string = environment.backendUrl;

  private response: string = "FAILURE";

  constructor(private http: HttpClient) { }

  testConnection(message: string): Observable<Response> {
    console.log(message);
    return this.http.get<Response>(this.BACKEND_URL + "/test", {observe: 'body', responseType: 'json'});
  }

  quit(serviceConnected: string) {
    return this.http.get<Response>(this.BACKEND_URL  + "/quit", {observe: 'body', responseType: 'json'});
  }
}
