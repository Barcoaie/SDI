import {Component} from "@angular/core";
import {RentalService} from "./shared/rental.service";
import {Router} from "@angular/router";

@Component({
    moduleId: module.id,
    selector: 'movie_rental-rentals',
    templateUrl: './rentals.component.html',
    styleUrls: ['./rentals.component.css'],
})
export class RentalsComponent {
  constructor(private router: Router) {
  }

  addNewRental() {
    console.log("add new rental button was clicked");
    this.router.navigate(["rental/new"]);
  }
}
