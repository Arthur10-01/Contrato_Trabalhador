
package entidades;

import entidades.Enum.Nivel;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Trabalhador {
    private String nome;
    private Nivel nivel;
    private Double baseSalarial;
    
    private Departamento departamento;
    private List <ContratoHora> contratos =  new ArrayList<>();
  

    
    
    public Trabalhador(){
        
    }
    public Trabalhador(String nome, Nivel nivel, Double baseSalarial, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.baseSalarial = baseSalarial;
        this.departamento = departamento;
    }   

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public void setBaseSalarial(Double baseSalarial) {
        this.baseSalarial = baseSalarial;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

        
    public String getNome() {
        return nome;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public Double getBaseSalarial() {
        return baseSalarial;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public List<ContratoHora> getContratos() {
        return contratos;
    }
     public void addContrato(ContratoHora contratos){
         this.contratos.add(contratos);
     }  
     public void removeContrato(ContratoHora contratos){
         this.contratos.remove(contratos);
     }
     public Double renda(int ano,int mes ){
       double soma = this.baseSalarial;
       Calendar cal = Calendar.getInstance();
       for(ContratoHora cert : this.contratos){
           cal.setTime(cert.getData());
           int cert_ano = cal.get(Calendar.YEAR);
           int cert_mes= 1+ cal.get(Calendar.MONTH);
        if (ano==cert_ano && mes==cert_mes){
            soma += cert.valorTotal();
        }
       }
          return soma;
     }
}
