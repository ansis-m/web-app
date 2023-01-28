import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {Podcast} from "../../models/podcast";
import {Track} from "../../models/track";

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
  time: number = 0;


  ngOnInit(): void {
  }

  toggle() {
    this.showTracklist = !this.showTracklist;
    this.tracklist = this.tracklist == "tracklist"? "hide" : "tracklist";
  }

  getCurrentTime(data: { target: { currentTime: number; }; }) {
    this.time = data.target.currentTime;
  }

  jump(timestamp: number): void {
    // @ts-ignore
    this.player.nativeElement.currentTime = timestamp;
  }

  addTimestamp(song: Track): void {
    //@ts-ignore
    song.timestamp = this.player.nativeElement.currentTime;
    console.log("Implement: send timestamp to Redis");
  }

  removeTimestamp(song: Track) {
    song.timestamp = -1;
  }

  getCurrentTrack(): string {
    //@ts-ignore
    let currentTime = this.player?.nativeElement?.currentTime;
    for(let i = 0; i < this.podcast.trackList.length; i++){
      if(this.podcast.trackList[i].timestamp <= currentTime && (this.podcast.trackList[i+1].timestamp > currentTime || this.podcast.trackList[i+1].timestamp == -1)){
        return this.podcast.trackList[i].title;
      }
    }
    return "";
  }
}
