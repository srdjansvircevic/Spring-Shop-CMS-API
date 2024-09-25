import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home/home.component';
import { ErrorComponent } from './pages/error/error.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent,

    },
    {
        path: 'category',
        loadChildren: () => import('./pages/category/category.module').then(m => m.CategoryModule)
    },
    {
        path: 'single-product',
        loadChildren: () => import('./pages/single-product/single-product.module').then(m => m.SingleProductModule)
    },
    { 
        path: 'error/*',
        component: ErrorComponent,
    },
        
    // Fallback or default route
    { path: '**', redirectTo: '/' }
];
