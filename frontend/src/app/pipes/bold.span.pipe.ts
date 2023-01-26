import { Pipe, PipeTransform, Sanitizer, SecurityContext } from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";

@Pipe({name: "boldSpan"})
export class BoldSpanPipe implements PipeTransform {

  private regex: string = "/\\(/";

  constructor(private sanitizer: DomSanitizer
  ) {}

  transform(value: string | undefined): string {
    if (value == undefined)
      return "";
    return this.sanitize(this.replace(value));
  }

  replace(str: string): string {
    console.log(str.replace(new RegExp(`(${/^.*?\(/})`, 'gi'), '<b>$1</b>'));
    return `<b>${str.split(/\(/)[0]}</b>${str.split(/[(|)]/)[1]}`
  }

  sanitize(str: string): string {
    return <string>this.sanitizer.bypassSecurityTrustHtml(str);
  }
}
