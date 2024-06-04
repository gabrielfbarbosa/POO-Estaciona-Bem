/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionabem;

/**
 *
 * @author breno
 */
public class Estacionamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Menus menu = new Menus();
       int opPrimaria, opSecundaria;
       boolean sair=false;
       
       while(sair = false){
           opPrimaria = menu.menuPrincipal();
           
           switch(opPrimaria){
               
               case 1:
                   opSecundaria = menu.menuGerenciarClientes();
                   if(opSecundaria == 1){
                       
                   } else if(opSecundaria == 2){
                       
                   } else if(opSecundaria == 3){
                       
                   } else if(opSecundaria == 4){
                       
                   } else if(opSecundaria == 5){
                       
                   } else if(opSecundaria == 6){
                       
                   } else if(opSecundaria == 7){
                       
                   } else{
                       
                   }
                   break;
                   
               case 2:
                   
                   opSecundaria = menu.menuGerenciarClientes();
                   if(opSecundaria == 1){
                       
                   } else if(opSecundaria == 2){
                       
                   } else if(opSecundaria == 3){
                       
                   } else if(opSecundaria == 4){
                       
                   } else if(opSecundaria == 5){
                       
                   } else if(opSecundaria == 6){
                       
                   } else{
                       
                   }
                   break;
               case 3:
                   
                   opSecundaria = menu.menuGerenciarClientes();
                   if(opSecundaria == 1){
                       
                   } else if(opSecundaria == 2){
                       
                   } else if(opSecundaria == 3){
                       
                   } else if(opSecundaria == 4){
                       
                   } else if(opSecundaria == 5){
                       
                   } else{
                       
                   }
                   break;
                   
               case 4:
                   
                   break;
                   
               case 5:
                   
                   break;
                   
               case 6:
                   
                   sair = true;
                   break;
           }
       }
    }
    
}
