import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface UsuarioCadastro {
  nome: string;
  email: string;
  senha: string;
  dataNascimento: string;
}

@Injectable({ providedIn: 'root' })
export class CadastroService {
  private apiUrl = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) {}

  cadastrarUsuario(usuario: UsuarioCadastro): Observable<any> {
    return this.http.post(this.apiUrl, usuario);
  }
}
