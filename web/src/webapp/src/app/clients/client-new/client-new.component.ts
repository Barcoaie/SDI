import {Component, OnInit} from '@angular/core';
import {ClientService} from "../shared/client.service";
import {Location} from "@angular/common";

@Component({
  selector: 'movie_rental-client-new',
  templateUrl: './client-new.component.html',
  styleUrls: ['./client-new.component.css']
})
export class ClientNewComponent implements OnInit {

  constructor(private clientService: ClientService,
              private location: Location
  ) {
  }

  ngOnInit(): void {
  }

  saveClient(name: string, cnp: string) {
    console.log("saving client", name, cnp);

    this.clientService.save({
      id: 0,
      name,
      cnp: +cnp
    })
      .subscribe(client => console.log("saved client: ", client));

    this.location.back(); // ...
  }
}
