import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Pet } from '../pet';
import { Type } from '../type';
import { Color } from '../color';
import { PetService } from '../pet.service';
import { ColorService } from '../color.service';
import { TypeService } from '../type.service';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent implements OnInit{

  errormsg:any;
  successmsg:any;
  pet: Pet = new Pet();
  petForm: FormGroup;
  colors:Color[];
  colorNames:string[];
  types:Type[];
  typeNames:string[];
  colorSelect:any;
  typeSelect:any;
  id!: number;
  isAddMode!: boolean;
  constructor(
    private fb: FormBuilder,
    private petService: PetService,
    private colorService: ColorService,
    private typeService: TypeService,
    private actrouter: ActivatedRoute,
    private router: Router
  ) {
    this.petForm = new FormGroup({});
    this.colors = [];
    this.colorNames = [];
    this.typeNames = [];
    this.types = [];
    {
      this.colorService.getColors().subscribe(colors => 
        this.colorNames = colors.map(color => color.color)
      );
    }
    
    {
      this.typeService.getTypes().subscribe(types => 
        this.typeNames = types.map(type => type.type)
      );
    }
  }

  ngOnInit(): void {
    this.id = this.actrouter.snapshot.params['id'];
    this.isAddMode = !this.id;
    { this.petForm = this.fb.group({
    name: ['', [Validators.required, Validators.pattern(/^[A-Za-z]+$/)]],
    code: ['', [Validators.required, Validators.pattern(/^\d+$/)]],
    type: ['', Validators.required],
    color: ['', Validators.required],
    });
    }
    if (!this.isAddMode) {
      this.petService.getById(this.id).subscribe(pet => {
        this.petForm.patchValue({
          name: pet.name,
          code: pet.code,
          type: pet.type,
          color: pet.color
        });
      });
    }
  }

  onSubmit() {
    if (this.petForm.valid) {
      const pet = {
        name: this.petForm.value.name,
        code: this.petForm.value.code,
        type: this.petForm.value.type,
        color: this.petForm.value.color,
      };

      if (this.isAddMode) {
        this.petService.createNewPet(pet).subscribe(res => {
          this.successmsg = res.message;
          this.petForm.reset();
          this.router.navigate(['/']);
        });
      } else {
      this.petService.editPet(this.id, pet).subscribe(res => {
        this.successmsg = res.message;
        this.petForm.reset();
        this.router.navigate(['/']);
      });
    }
    } else {
      this.errormsg ="All fields are required.";
    }
  }
}