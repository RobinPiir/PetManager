import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pet } from './pet';

@Injectable({
  providedIn: 'root'
})
export class PetService {
  private url = "http://localhost:8080/api/"
  private getUrl = `${this.url}getAll`;
  private getByIdUrl = `${this.url}pet`;
  private editUrl = `${this.url}updatePet`;
  private addUrl = `${this.url}addPet`;
  
  constructor(private http: HttpClient) { }

  getPets(): Observable<Pet[]>{
    return this.http.get<Pet[]>(this.getUrl);
  }

  getById(id: number): Observable<Pet>{
    return this.http.get<Pet>(`${this.getByIdUrl}/${id}`);
  }

  editPet(id: number, pet: Omit<Pet,'id'>): Observable<any>{
    return this.http.post<Pet>(`${this.editUrl}/${id}`, pet);
  }

  createNewPet(pet: Omit<Pet, 'id'>): Observable<any> {
    return this.http.post<any>(this.addUrl, pet);
  }
}
