import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Home } from './model/home.model';
import { environment } from '../../../environments/environment';


@Injectable()
export class HomeService {

  private getHomeUrl = 'pages/home';
  private apiUrl = environment.API_URL;

  constructor(private http: HttpClient) { }

  getHome(): Observable<Home> {
    return this.http.get<Home>(`${this.apiUrl}/${this.getHomeUrl}`);
  }
}
