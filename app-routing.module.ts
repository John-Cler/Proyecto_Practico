import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CountryService} from './Services/country.service';

const routes: Routes = [
  { path: 'country', component: CountryService },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
