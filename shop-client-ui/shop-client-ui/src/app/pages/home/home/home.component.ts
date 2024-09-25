import { Component, OnInit} from '@angular/core';
import { Home } from '../model/home.model';
import { ActivatedRoute } from '@angular/router';
import { HomeService } from '../home.service';


@Component({
  selector: 'home-home',
  templateUrl: './home.component.html',
  standalone: true,
})

export class HomeComponent implements OnInit {

  homeData: Home| null = null;

  loading: boolean = true;
  error: string | null = null;


  constructor(
    private route: ActivatedRoute,
    private homeService: HomeService
  ) {}
  
  ngOnInit(): void {
    this.loadHomePageData();
  }
  
  loadHomePageData(): void {
    this.homeService.getHome().subscribe({
      next: (data) => {
        this.homeData = data;
        this.loading = false;
      },
      error: (error) => {
        this.error = error?.message || 'server error' ;
        console.error('Error fetching home page data', error);
      }
    });
  }
}