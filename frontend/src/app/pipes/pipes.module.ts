import {NgModule} from "@angular/core";
import {StripExtensionPipe} from "./strip.extension.pipe";

@NgModule({
  declarations: [
    StripExtensionPipe
  ],
  exports: [
    StripExtensionPipe
  ]
})
export class PipesModule{

}
