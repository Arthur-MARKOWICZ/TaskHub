import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private accessTokenSubject = new BehaviorSubject<string | null>(null);
  private apiUrl = 'http://localhost:8080/api/usuarios'; // ajuste conforme seu backend

  constructor(private http: HttpClient) {}

  // Obter token atual
  getToken(): string | null {
    return this.accessTokenSubject.value;
  }

  // Guardar token em memória
  setToken(token: string | null) {
    this.accessTokenSubject.next(token);
  }

  // Login
  login(email: string, senha: string): Observable<any> {
    return this.http.post<{ accessToken: string }>(
      `${this.apiUrl}/login`,
      { email, senha },
      { withCredentials: true } // MUITO IMPORTANTE -> envia cookies
    ).pipe(
      tap(res => this.setToken(res.accessToken))
    );
  }

  // Refresh token
  refreshToken(): Observable<any> {
    return this.http.post<{ accessToken: string }>(
      `${this.apiUrl}/refresh`,
      {},
      { withCredentials: true }
    ).pipe(
      tap(res => this.setToken(res.accessToken))
    );
  }

  logout() {
    this.setToken(null);
    // opcional: chamar endpoint de logout no backend
  }
}
