import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPetComponent } from './add-pet/add-pet.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PetComponent } from './pet/pet.component';

const routes: Routes = [
  { path: '', component: PetComponent },
  {path: 'add', component: AddPetComponent},
  {path: 'edit/:id', component: AddPetComponent}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),
  FormsModule, ReactiveFormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
