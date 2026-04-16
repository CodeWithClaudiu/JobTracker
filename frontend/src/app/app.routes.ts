import { Routes } from '@angular/router';
import { HomePage } from './home-page/home-page';
import { PlacementProfile } from './placement-profile';
import { JobApplication } from './job-application';
import { WeekApplication } from './week-application';

export const routes: Routes = [ 
    { path: '', component: HomePage },
    {path: 'home', component: HomePage},
    {path: 'placement-profile', component: PlacementProfile},
    {path: 'job-applications',component: JobApplication},
    {path: 'week-applications',component: WeekApplication}


]; 
