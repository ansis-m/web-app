import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {PipesModule} from "./pipes/pipes.module";
import { QemPlayerComponent } from './components/qem.player/qem.player.component';

@NgModule({
  declarations: [
    AppComponent,
    QemPlayerComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        PipesModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
