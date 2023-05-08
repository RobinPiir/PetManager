import { Component, OnInit } from '@angular/core';
import { Pet } from '../pet';
import { PetService } from '../pet.service';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit{

  pets: Pet[] = [];
  constructor(private petService: PetService){}

  ngOnInit(): void {
    this.petService.getPets().subscribe((data: Pet[]) => {
      console.log(data);
      this.pets = data;
    });
  }
}
