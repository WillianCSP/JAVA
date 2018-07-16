package br.com.dextra.livraria.bean;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
//public class LivrariaException extends Exception {
public class LivrariaException extends RuntimeException { // tornando uncheked

}
