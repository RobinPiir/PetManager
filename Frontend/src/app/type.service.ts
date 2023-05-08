import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Type } from './type';

@Injectable({
  providedIn: 'root'
})
export class TypeService {
  private url = "http://localhost:8080/api/getTypes"

  constructor(private http: HttpClient) { }

  getTypes(): Observable<Type[]>{
    return this.http.get<Type[]>(`${this.url}`)
  }
}
