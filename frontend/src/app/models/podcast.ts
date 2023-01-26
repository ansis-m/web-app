export class Podcast {
  fileName: string;
  showTrackList: boolean;
  trackList: string[];

  constructor() {
    this.fileName = "";
    this.showTrackList = false;
    this.trackList = [];
  }
}
