import {NgModule} from "@angular/core";
import {StripExtensionPipe} from "./strip.extension.pipe";
import {BoldSpanPipe} from "./bold.span.pipe";
import {TimeStampPipe} from "./time.stamp.pipe";

@NgModule({
  declarations: [
    StripExtensionPipe,
    BoldSpanPipe,
    TimeStampPipe
  ],
  exports: [
    StripExtensionPipe,
    BoldSpanPipe,
    TimeStampPipe
  ]
})
export class PipesModule{

}
