import { Component, OnInit } from '@angular/core';
import {CountryService } from './Services/country.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'My_App';

  lista:string[]=[];

  constructor() {
    private router: Router,
    private CountryService: CountryService,
    private ngZone: NgZone;
    
  }
  ngOnInit(): void {
    this.CountryService.getLabels().subscribe((dato) => {
      this.ngZone.run(() => {
        this.labels = dato;
      });
    });
  }
  private getAllConutry(){

  }

}
