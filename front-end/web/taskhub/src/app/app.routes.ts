
import { Routes } from '@angular/router';
import { Cadastro } from './components/cadastro/cadastro';
import { Login } from './components/login/login';

export const routes: Routes = [
	{ path: 'cadastro', component: Cadastro },
  { path: 'login', component: Login }
];
