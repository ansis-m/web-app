import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Podcast} from "../models/podcast";

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private BACKEND_URL: string = environment.backendUrl;

  constructor(private http: HttpClient) { }

  getFilenames() {
    return this.http.get<Podcast[]>(this.BACKEND_URL  + "/filenames", {observe: 'body', responseType: 'json'});
  }

  addTimeStamp(fileName: string, trackTitle: string, timestamp: number) {
    return this.http.post<number>(this.BACKEND_URL  + "/timestamp/add/" + fileName + "/" + trackTitle, timestamp, {observe: 'body', responseType: 'json'});

  }

  removeTimeStamp(fileName: string, title: string) {
    return this.http.post<number>(this.BACKEND_URL  + "/timestamp/remove/" + fileName + "/" + title, 0, {observe: 'body', responseType: 'json'});
  }
}
