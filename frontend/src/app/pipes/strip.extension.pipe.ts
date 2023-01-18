import {Pipe, PipeTransform} from "@angular/core";


@Pipe({name: "StripExtensionPipe"})
export class StripExtensionPipe implements PipeTransform{

  transform(filename: string): string {
    return filename.split(".")[0];
  }
}
