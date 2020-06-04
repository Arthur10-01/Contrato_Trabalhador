
package aplication01;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Enum.Nivel;
import entidades.Trabalhador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;
public class Principal {

    
    public static void main(String[] args) throws ParseException {
       Locale.setDefault(Locale.US);
       Scanner ler = new Scanner(System.in);
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       System.out.print("Entre com o Departamento ");
       String departamento = ler.nextLine();
       ler.nextLine();
       System.out.println("Digite os dados do Trabalhador: ");
       System.out.print("Name : ");
       String name = ler.nextLine();
         System.out.print("Nivel : ");
       String nivel = ler.nextLine();
         System.out.print("Base Salarial : ");
       double salarioBase = ler.nextDouble();
       
       Trabalhador trabalhador = new Trabalhador(name,Nivel.valueOf(nivel),salarioBase,new Departamento(departamento));
        
         System.out.print("Quantos contratos esse trabalhador possui? ");
         int n = ler.nextInt();
         for (int i = 1 ;i<=n;i++){
             System.out.println("Entre com o contrato "+i+" : ");
              
              System.out.print("Data (DD/MM/YYYY): ");
               Date data = sdf.parse(ler.next());
               System.out.print("Valor por Hora: ");
               double valorPorHora = ler.nextDouble();
               System.out.print("Duração (Horas): ");
               int duracao = ler.nextInt();
               
               ContratoHora contratohora = new ContratoHora(data,valorPorHora,duracao);
               
               trabalhador.addContrato(contratohora);
         }
         System.out.println();
         System.out.print("Digite o mês e o ano do contrato para calcular o salario (MM/YYYY)  ");
         String mesAno = ler.next();
         int mes = Integer.parseInt(mesAno.substring(0,2));
         int ano = Integer.parseInt(mesAno.substring(3));
         
         System.out.println("Nome: "+trabalhador.getNome());
         System.out.println("Departamento:"+trabalhador.getDepartamento().getName());
          System.out.println("Renda para "+mesAno+" : "+String.format("%.2f", trabalhador.renda(ano, mes)));
            
      
       
       ler.close();
       
    }
    
}
