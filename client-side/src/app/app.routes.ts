import { Routes } from '@angular/router';
import { FormsComponent } from './Components/forms/forms.component';
import { MyTasksComponent } from './Components/my-tasks/my-tasks.component';
import { RegisterComponent } from './Components/register/register.component';
import { LoginComponent } from './Components/login/login.component';


export const routes: Routes = [

    {
        path : "my-tasks",
        component : MyTasksComponent
    },

    {
    path : "create",
    component : FormsComponent
        
    },

    {
        path:"register",
        component : RegisterComponent
    },

    {
        path:"login",
        component: LoginComponent
    }
];
