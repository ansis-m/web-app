import { Component } from '@angular/core';
import {TService} from "../services/services/t.service";
import {environment} from "../environments/environment";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Running the script!!!';
  backendUrl = environment.backendUrl

  constructor(private testService: TService) {
  }

  testConnection() {
    console.log("Button Pushed");
    this.testService.testConnection("Service Connected").subscribe(
      response => {
            console.log(response);
            this.title = response.status;
            setTimeout(() => this.title = 'Running the script!!!', 500);
          });

  }

  quit() {
    this.testService.quit("Service Connected").subscribe(response => {console.log("closing")});
  }
}
