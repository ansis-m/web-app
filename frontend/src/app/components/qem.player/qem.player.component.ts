import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {Podcast} from "../../models/podcast";

@Component({
  selector: 'qem-player',
  templateUrl: './qem.player.component.html',
  styleUrls: ['./qem.player.component.css']
})
export class QemPlayerComponent implements OnInit{
  @Input()
  podcast: Podcast = new Podcast();
  @Input()
  backendUrl: string = "";

  @ViewChild('player') player: ElementRef | undefined;
  showTracklist: boolean = false;
  tracklist: string = "tracklist";
  time: string = "";

  ngOnInit(): void {
  }

  toggle() {
    this.showTracklist = !this.showTracklist;
    this.tracklist = this.tracklist == "tracklist"? "hide" : "tracklist";
  }


  getCurrentTime(data: { target: { currentTime: string; }; }) {
    console.log(this.player?.nativeElement.getAttribute("currentTime"));
    this.time = data.target.currentTime;
  }

  setCurrentTime() {
    // @ts-ignore
    this.player.nativeElement.currentTime = 100;
  }
}
