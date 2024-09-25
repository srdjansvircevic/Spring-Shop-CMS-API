import { Injectable } from '@angular/core';

@Injectable({providedIn: 'root'})
export class LocalStorageService {

    prefix : string = 'shop-client-ui';

    constructor() { }

    getItem(key: string){
        return window.localStorage.getItem(`${ this.prefix }-${ key }`);
    }

    setItem(key: string, value: string){
        window.localStorage.setItem(`${ this.prefix }-${ key }`, value);
    }

    removeItem(key: string){
        window.localStorage.removeItem(`${ this.prefix }-${ key }`);
    }

}