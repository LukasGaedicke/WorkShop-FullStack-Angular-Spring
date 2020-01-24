import { Component, OnInit } from '@angular/core';
import { OportunidadeService } from '../oportunidade.service';
import {MessageService} from 'primeng/api';
import {ToastModule} from 'primeng/toast';


@Component({
  selector: 'app-painel-negociacao',
  templateUrl: './painel-negociacao.component.html',
  styleUrls: ['./painel-negociacao.component.css']
})
export class PainelNegociacaoComponent implements OnInit {

  oportunidade = {};
  oportunidades = [];
  
  constructor(
    private opotunidadeService : OportunidadeService,
    private messageService: MessageService
    ) { }

  ngOnInit() {
    this.consultar();
    this.adicionar();
  }
  consultar(){
    //<any> -- cast para qualquer coisa
    this.opotunidadeService.listar().subscribe(resposta => this.oportunidades= <any> resposta);
  }
  adicionar(){
    this.opotunidadeService.adicionar(this.oportunidade)
    .subscribe(() => {
      this.oportunidade = {};
      this.consultar();

      this.messageService.add({
        severity:'success', 
        summary:'Oportunidade salva com sucesso.', 
        detail:'Via MessageService'});
    }, resposta =>{
      let msg = 'Erro inesperado. Tente novamente.';
      if (resposta.error.message) {
        msg = resposta.error.message;
      }

      this.messageService.add({
        severity:'error', 
        summary:msg, 
        detail:'Via MessageService'});
    });
  }

}
