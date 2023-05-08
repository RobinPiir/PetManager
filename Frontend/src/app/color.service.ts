import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Color } from './color';

@Injectable({
  providedIn: 'root'
})
export class ColorService {
  private url = "http://localhost:8080/api/getColors"

  constructor(private http: HttpClient) { }

  getColors(): Observable<Color[]>{
    return this.http.get<Color[]>(`${this.url}`)
  }
  
}
