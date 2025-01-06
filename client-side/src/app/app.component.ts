import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MenuComponent } from "./Components/menu/menu.component";
import { FormsComponent } from "./Components/forms/forms.component";
import { HomeComponent } from "./Components/home/home.component";


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,HomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'task-scape-app';
}
