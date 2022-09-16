import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel2',
  templateUrl: './carousel2.component.html',
  styleUrls: ['./carousel2.component.css'],
})
export class Carousel2Component implements OnInit {
  constructor() {}

  ngOnInit(): void {}
  images = [1, 2, 3, 4, 5, 6].map((n) => `assets/imagediapo2/diapo${n}.png`);
}
