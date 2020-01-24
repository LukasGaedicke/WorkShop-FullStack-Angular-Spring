import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OportunidadeService {

  apiUrl = 'http://localhost:8080/oportunidades';

  constructor(private httpClient : HttpClient) { }
  
  //retorna um obj observable
  listar(){
    return this.httpClient.get(this.apiUrl);
  }
  adicionar(oportunidade : any){
    return this.httpClient.post(this.apiUrl, oportunidade);
  }
}
