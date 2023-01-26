import {NgModule} from "@angular/core";
import {StripExtensionPipe} from "./strip.extension.pipe";
import {BoldSpanPipe} from "./bold.span.pipe";

@NgModule({
  declarations: [
    StripExtensionPipe, BoldSpanPipe
  ],
  exports: [
    StripExtensionPipe, BoldSpanPipe
  ]
})
export class PipesModule{

}
