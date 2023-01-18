import {Component, Input} from '@angular/core';

@Component({
  selector: 'qem-player',
  templateUrl: './qem.player.component.html',
  styleUrls: ['./qem.player.component.css']
})
export class QemPlayerComponent {
  @Input()
  filename: string | undefined;
  @Input()
  backendUrl: string | undefined;

}
