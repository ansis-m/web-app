import {Track} from "./track";

export class Podcast {
  fileName: string;
  showTrackList: boolean;
  trackList: Track[];

  constructor() {
    this.fileName = "";
    this.showTrackList = false;
    this.trackList = [];
  }
}
