import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Marchandise } from 'src/app/model/marchandise';
import { MarchandiseService } from 'src/app/services/marchandise.service';

@Component({
  selector: 'app-marchandise-list',
  templateUrl: './marchandise-list.component.html',
  styleUrls: ['./marchandise-list.component.css']
})
export class MarchandiseListComponent implements OnInit {
  observableMarchandises: Observable<Marchandise[]>;
  message = '';
  showMessage = false;
  constructor(
    private marchandiseService: MarchandiseService,
    private activatedRoute: ActivatedRoute
  ) {
    this.observableMarchandises = this.marchandiseService.getAll();
  }

  ngOnInit(): void {
    this.showMessage = false;
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `marchandise ${params['id']} créé`;
        } else {
          this.message = `marchandise ${params['id']} modifié`;
        }
        this.showMessage = true;
      }
    });
  }

  delete(id: number) {
    this.marchandiseService.deleteById(id).subscribe(() => {
      this.observableMarchandises = this.marchandiseService.getAll();
    });
  }


}
