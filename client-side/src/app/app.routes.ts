import { Routes } from '@angular/router';
import { FormsComponent } from './Components/forms/forms.component';
import { MyTasksComponent } from './Components/my-tasks/my-tasks.component';


export const routes: Routes = [

    {
        path : "my-tasks",
        component : MyTasksComponent
    }

    //{
    //path : "create",
    //component : FormsComponent
        
    //}
];
