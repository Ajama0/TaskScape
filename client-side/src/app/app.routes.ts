import { Routes } from '@angular/router';
import { FormsComponent } from './Components/forms/forms.component';
import { MyTasksComponent } from './my-tasks/my-tasks.component';


export const routes: Routes = [

    {
        path : "my-tasks",
        component : MyTasksComponent
    },

    {
    path : "home",
    component : FormsComponent
        
    }
];
