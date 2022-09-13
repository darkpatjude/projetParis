import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Marchandise } from 'src/app/model/marchandise';
import { MarchandiseService } from 'src/app/services/marchandise.service';

@Component({
  selector: 'app-marchandise-edit',
  templateUrl: './marchandise-edit.component.html',
  styleUrls: ['./marchandise-edit.component.css']
})
export class MarchandiseEditComponent implements OnInit {
  marchandise: Marchandise;

  constructor(
    private marchandiseService: MarchandiseService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.marchandise = new Marchandise();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.marchandiseService.getById(params['id']).subscribe((result) => {
          this.marchandise = result;
        });
      }
    });
  }

  save() {
    if (this.marchandise.id) {
      this.marchandiseService.update(this.marchandise).subscribe(() => {
        this.router.navigateByUrl('/marchandise?q=update&id=' + this.marchandise.id);
      });
    } else {
      this.marchandiseService.create(this.marchandise).subscribe({
        next: (result) => {
          this.router.navigateByUrl('/marchandise?q=create&id=' + result.id);
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }

}
