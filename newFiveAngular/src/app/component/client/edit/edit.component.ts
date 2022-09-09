import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  client: Client;

  constructor(
    private ar: ActivatedRoute,
    private clientService: ClientService,
    private router: Router
  ) {
    this.client = new Client();
  }

  ngOnInit(): void {
    this.ar.params.subscribe((params) => {
      if (params['id']) {
        this.clientService.getById(params['id']).subscribe((result) => {
          this.client = result;
        });
      }
    });
  }

  save() {
    if (this.client.id_client) {
      this.clientService.update(this.client).subscribe(() => {
        this.router.navigateByUrl('/client?q=update&id=' + this.client.id_client);
      });
    } else {
      this.clientService.create(this.client).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/client?q=create&id=' + result.id_client);
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }

}
