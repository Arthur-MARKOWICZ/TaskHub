import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { CadastroService, UsuarioCadastro } from '../../services/cadastro.service';


@Component({
  selector: 'app-cadastro',
  imports: [FormsModule],
  templateUrl: './cadastro.html',
  styleUrl: './cadastro.css'
})
export class Cadastro {
  constructor(private cadastroService: CadastroService) {}

  onSubmit(form: NgForm) {

      const usuario: UsuarioCadastro = form.value;
      this.cadastroService.cadastrarUsuario(usuario).subscribe({
        next: (res) => {
          console.log('Usuário cadastrado com sucesso!', res);

        },
        error: (err) => {
          console.error('Erro ao cadastrar usuário:', err);
          // Aqui pode exibir mensagem de erro
        }
      });
    }
  }

