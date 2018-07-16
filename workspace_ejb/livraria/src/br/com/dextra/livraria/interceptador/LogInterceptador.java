package br.com.dextra.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception{
		
		 long millis = System.currentTimeMillis(); 
		 
		  // chamada do método do dao 
		 Object object = context.proceed();

		 String metodo = "Metodo -"+context.getMethod().getName(); 
		 String nomeClasse = "Classe -"+context.getTarget().getClass().getSimpleName(); 
		 System.out.println();
		 System.out.println();
		 System.out.println("-----------LOG INTERCEPTADOR-----------");
		 System.out.println(nomeClasse + ", " + metodo);
		 System.out.println("Tempo gasto:  " + (System.currentTimeMillis()- millis)); 
		 System.out.println("-----------LOG INTERCEPTADOR-----------");
		 System.out.println();
		 System.out.println(""+context.getContextData().containsValue("admin"));
		 
		 return object;
	}
}
