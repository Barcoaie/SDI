import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ClientsComponent} from "./clients/clients.component";
import {ClientDetailComponent} from "./clients/client-detail/client-detail.component";
import {MoviesComponent} from "./movies/movies.component";
import {MovieDetailComponent} from "./movies/movie-detail/movie-detail.component";
import {RentalsComponent} from "./rentals/rentals.component";
import {RentalDetailComponent} from "./rentals/rental-detail/rental-detail.component";
import {ClientNewComponent} from "./clients/client-new/client-new.component";
import {MovieNewComponent} from "./movies/movie-new/movie-new.component";
import {RentalNewComponent} from "./rentals/rental-new/rental-new.component";

const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'clients', component: ClientsComponent},
  {path: 'client/detail/:id', component: ClientDetailComponent},
  {path: 'movies', component: MoviesComponent},
  {path: 'movie/detail/:id', component: MovieDetailComponent},
  {path: 'rentals', component: RentalsComponent},
  {path: 'rental/detail/:id', component: RentalDetailComponent},
  {path: 'client/new', component: ClientNewComponent},
  {path: 'movie/new', component: MovieNewComponent},
  {path: 'rental/new', component: RentalNewComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
