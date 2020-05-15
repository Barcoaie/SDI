import {Component} from "@angular/core";
import {MovieService} from "./shared/movie.service";
import {Router} from "@angular/router";

@Component({
    moduleId: module.id,
    selector: 'movie_rental-movies',
    templateUrl: './movies.component.html',
    styleUrls: ['./movies.component.css'],
})
export class MoviesComponent {
  constructor(private router: Router) {
  }

  addNewMovie() {
    console.log("add new movie button was clicked");
    this.router.navigate(["movie/new"]);
  }
}
