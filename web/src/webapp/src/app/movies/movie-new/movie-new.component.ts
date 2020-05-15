import {Component, OnInit} from '@angular/core';
import {MovieService} from "../shared/movie.service";
import {Location} from "@angular/common";

@Component({
  selector: 'movie_rental-movie-new',
  templateUrl: './movie-new.component.html',
  styleUrls: ['./movie-new.component.css']
})
export class MovieNewComponent implements OnInit {

  constructor(private movieService: MovieService,
              private location: Location
  ) {
  }

  ngOnInit(): void {
  }

  saveMovie(title: string, description: string) {
    console.log("saving movie", title, description);

    this.movieService.save({
      id: 0,
      title,
      description
    })
      .subscribe(movie => console.log("saved movie: ", movie));

    this.location.back(); // ...
  }
}
