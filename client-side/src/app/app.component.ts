import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MenuComponent } from "./Components/menu/menu.component";
import { FormsComponent } from "./Components/forms/forms.component";


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,FormsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'task-scape-app';
}
