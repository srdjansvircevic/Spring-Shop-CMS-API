import { Injectable } from '@angular/core';
import { LocalStorageService } from '../data/local-storage.service';

@Injectable({providedIn: 'root'})
export class AuthService {
    constructor(private localStorageService: LocalStorageService) { }

    getToken(){
        return this.localStorageService.getItem('token');
    }
    
    setToken(token: string){
        this.localStorageService.setItem('token', token);
    }
}