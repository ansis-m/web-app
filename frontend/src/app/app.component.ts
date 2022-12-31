import { Component } from '@angular/core';
import {TestService} from "../services/services/test.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  constructor(private testService: TestService) {
  }

  testConnection() {
    console.log("Button Pushed");
    this.testService.testConnection("Service Connected").subscribe(response => {console.log(response), this.title = response.status});
  }
}
