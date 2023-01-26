import {Component, OnInit} from '@angular/core';
import {BackendService} from "./services/backend.service";
import {environment} from "../environments/environment";
import {Title} from "@angular/platform-browser";
import {Podcast} from "./models/podcast";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title: string = 'QuincyEssentialMusic';
  backendUrl: string = environment.backendUrl
  podcasts: Podcast[] = [];

  constructor(private backendService: BackendService,
              private titleService: Title) {
    titleService.setTitle("QuincyEssentialMusic");
  }

  ngOnInit(): void {
    this.backendService.getFilenames().subscribe((result: Podcast[]) => {
      this.podcasts = result;
      this.podcasts.forEach(p => console.log(p.fileName))
    });

  }
}
