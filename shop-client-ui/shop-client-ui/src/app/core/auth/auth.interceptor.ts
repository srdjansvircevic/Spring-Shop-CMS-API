import { HttpEvent, HttpEventType, HttpHandlerFn, HttpHeaders, HttpRequest, HttpStatusCode } from "@angular/common/http";
import { inject } from "@angular/core";
import { AuthService } from "./auth.service";
import { Observable, tap } from "rxjs";
import { Router } from "@angular/router";

export function authInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn) {
    const token = inject(AuthService).getToken();
    if(token == null){
        return next(req);
    }
    const newReq = req.clone({
      headers: req.headers.append('Authorization', `Bearer${token}`),
    });
    return next(newReq);
  }

export function errorInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn): Observable<HttpEvent<unknown>> {
    return next(req).pipe(tap(event => {
      if (event.type === HttpEventType.Response && event.status == HttpStatusCode.Unauthorized) {
        console.log(req.url, 'returned a response with status', event.status);
        const router = inject(Router);
        router.navigateByUrl('/error/unauthorized');
      }
    }));
  }

