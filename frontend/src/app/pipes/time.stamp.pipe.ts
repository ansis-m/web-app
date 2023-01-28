import { Pipe, PipeTransform, Sanitizer, SecurityContext } from '@angular/core';


@Pipe({name: "timestampPipe"})
export class TimeStampPipe implements PipeTransform {


    transform(input: number): string {
        let seconds = Math.floor(input % 60);
        let secondsString = (seconds < 10)? "0" + String(seconds) : String(seconds);
        return String(Math.floor(input / 60)) + ":" + secondsString;
    }
}
