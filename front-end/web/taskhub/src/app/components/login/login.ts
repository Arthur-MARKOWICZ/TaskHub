import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { AuthService  } from '../../services/login.service';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  email: string = '';
  senha: string = '';

  constructor(private authService: AuthService){}

  onSubmit(form: NgForm) {
    this.email = form.value.email;
    this.senha = form.value.senha;
    this.authService.login(this.email, this.senha).subscribe({
      next: res => {
        console.log('Login feito com sucesso!', res.accessToken);
        // redirecionar usuário para dashboard
      },
      error: err => console.error('Erro no login', err)
    });
  }
}
