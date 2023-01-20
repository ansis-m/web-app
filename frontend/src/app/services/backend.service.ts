import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class TService {

  private BACKEND_URL: string = environment.backendUrl;

  constructor(private http: HttpClient) { }

  getFilenames() {
    return this.http.get<string[]>(this.BACKEND_URL  + "/filenames", {observe: 'body', responseType: 'json'});
  }
}
