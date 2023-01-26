import {Pipe, PipeTransform} from "@angular/core";

@Pipe({name: "StripExtensionPipe"})
export class StripExtensionPipe implements PipeTransform{

  transform(filename: string | undefined): string {
    if (filename !== undefined)
      return filename.split(".")[0];
    return "";
  }
}
