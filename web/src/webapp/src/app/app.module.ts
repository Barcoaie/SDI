import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {ClientDetailComponent} from "./clients/client-detail/client-detail.component";
import {ClientsComponent} from "./clients/clients.component";
import {ClientListComponent} from "./clients/client-list/client-list.component";
import {ClientService} from "./clients/shared/client.service";
import {MovieDetailComponent} from "./movies/movie-detail/movie-detail.component";
import {MoviesComponent} from "./movies/movies.component";
import {MovieListComponent} from "./movies/movie-list/movie-list.component";
import {MovieService} from "./movies/shared/movie.service";
import {RentalDetailComponent} from "./rentals/rental-detail/rental-detail.component";
import {RentalsComponent} from "./rentals/rentals.component";
import {RentalListComponent} from "./rentals/rental-list/rental-list.component";
import {RentalService} from "./rentals/shared/rental.service";
import {ClientNewComponent} from "./clients/client-new/client-new.component";
import {MovieNewComponent} from "./movies/movie-new/movie-new.component";
import {RentalNewComponent} from "./rentals/rental-new/rental-new.component";


@NgModule({
  declarations: [
    AppComponent,
    ClientDetailComponent,
    ClientsComponent,
    ClientListComponent,
    MovieDetailComponent,
    MoviesComponent,
    MovieListComponent,
    RentalDetailComponent,
    RentalsComponent,
    RentalListComponent,
    ClientNewComponent,
    MovieNewComponent,
    RentalNewComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [ClientService,MovieService,RentalService,],
  bootstrap: [AppComponent]
})
export class AppModule {
}
