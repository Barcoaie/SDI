import {Component} from "@angular/core";
import {ClientService} from "./shared/client.service";
import {Router} from "@angular/router";

@Component({
    moduleId: module.id,
    selector: 'movie_rental-clients',
    templateUrl: './clients.component.html',
    styleUrls: ['./clients.component.css'],
})
export class ClientsComponent {
  constructor(private router: Router) {
  }

  addNewClient() {
    console.log("add new client button was clicked");
    this.router.navigate(["client/new"]);
  }
}
