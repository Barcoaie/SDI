import {Component, OnInit} from '@angular/core';
import {RentalService} from "../shared/rental.service";
import {Location} from "@angular/common";
import {Client} from "../../clients/shared/client.model";
import {Movie} from "../../movies/shared/movie.model";
import {ClientService} from "../../clients/shared/client.service";
import {MovieService} from "../../movies/shared/movie.service";

import {map, filter} from "rxjs/operators";



@Component({
  selector: 'movie_rental-rental-new',
  templateUrl: './rental-new.component.html',
  styleUrls: ['./rental-new.component.css']
})
export class RentalNewComponent implements OnInit {

  constructor(private rentalService: RentalService,
              private location: Location
  ) {
  }

  ngOnInit(): void {
  }

  rent(mid: string, title: string, description: string, cid: string, name: string, cnp: string, date: string) {
    console.log("saving rental", mid, title, description, cid, name, cnp, date);

    this.rentalService.save({
      id: 0,
      movie: {id: +mid, title, description},
      client: {id: +cid, name, cnp: +cnp},
      date
    })
      .subscribe(rental => console.log("saved rental: ", rental));

    this.location.back(); // ...
  }
}
