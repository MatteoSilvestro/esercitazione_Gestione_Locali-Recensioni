package LocaliRecensioni;

import java.io.*;

public class Main {
	public static void main(String[] args) {

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera= new BufferedReader (input);
   
    int n=0,cont=0,stelle=0;
    String dato="",denominazione="",indirizzo="",utente="",commento="";
    boolean condizione2 = true;
    Locale lo[];
    lo = new Locale[1000];
    
	String tmp_den="",tmp_ind="";
    

    while(condizione2) {
    	System.out.println("1. Registrazione nuovo locale ");
    	System.out.println("2. Registrare una recensione ");
    	System.out.println("3. Ricercare locale con valutazione media maggiore di tutti ");
    	System.out.println("4. Ricercare locale che abbia almeno una valutazione con 4 stelle ");
    	System.out.println("5 - Esci");
    	
    	do {

    	try{
    		System.out.println("Inserire l'interazione: ");
    		dato = tastiera.readLine();
    		n = Integer.valueOf(dato).intValue();
    	}catch(Exception e) {}
    	
    	}while(n<1 && n>5);


    	switch(n) {
    	case 1 :
    		try {
        		System.out.println("inserire la denominazione del locale : ");
        		denominazione = tastiera.readLine();
        		System.out.println("inserire l'indirizzo del locale : ");
        		indirizzo = tastiera.readLine();
        	}catch(Exception e){
        		System.out.println("errore di inserimento");
        	}
    		lo[cont] = new Locale (denominazione,indirizzo);
    		cont++;
    		break;
    	case 2:
    		int n1=0;
    		try {
        		System.out.println("inserire il locale del quale si vuole inserire la recensione : ");
        		for(int i=0;i<cont;i++) {
        			System.out.println((1+n1)+" - "+lo[i].denominazione);
        		}
        		n1 = Integer.valueOf(tastiera.readLine()).intValue();
        	}catch(Exception e) {}
    		try {
        		System.out.println("inserire l'utente : ");
        		utente = tastiera.readLine();
        		System.out.println("inserire le stelle da 0 a 4: ");
        		do{
        			stelle = Integer.valueOf(tastiera.readLine()).intValue();
        		}while(stelle<0 && stelle >4);
        		System.out.println("inserire il commento : ");
        		commento = tastiera.readLine();
        	}catch(Exception e){
        		System.out.println("errore di inserimento");
        	}
    		lo[n1-1].registraRecensione(utente,commento ,stelle );
    		break;
    		
    	case 3:
    		
    		for (int i=0;i<cont-1;i++) {
    			for(int j=0;j<cont-2-i;j++) {
    				if(lo[j].CalcMedia()>lo[j+1].CalcMedia()) {
    					tmp_den = lo[j].denominazione;
    					tmp_ind = lo[j].indirizzo;

    					
    					lo[j].denominazione = lo[j+1].denominazione;
    					lo[j].indirizzo = lo[j+1].indirizzo;
    					
    					lo[j+1].denominazione = tmp_den;
    					lo[j+1].indirizzo = tmp_ind;

    				}
    			}
    		}
    		System.out.println("Il locale con la media valutazione migliore è: "+lo[0].denominazione);
    		break;
    	case 4:
    		for(int i=0;i<cont-1;i++) {
    			for(int j=0;j<lo[i].Nrecensioni;j++) {
    				if(lo[i].recensioni[j].Stelle>=4) {
    					System.out.println("Il locale "+lo[i].denominazione+" presenta una valutazione con almeno 4 stelle!");
    					break;
    				}
    			}
    		}
    		break;
    	case 5:
    		condizione2 = false;
    		break;
    	 default:
    		break;
}

}}}
