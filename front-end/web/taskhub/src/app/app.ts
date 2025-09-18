import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Cadastro } from './components/cadastro/cadastro';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Cadastro],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('taskhub');
}
