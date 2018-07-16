	

package ui;
     
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.NoResultException;

import br.com.dextrainig.MediaStore.entidades.Cliente;
import br.com.dextrainig.MediaStore.entidades.ItemVenda;
import br.com.dextrainig.MediaStore.entidades.Musica;
import br.com.dextrainig.MediaStore.entidades.Produto;
import br.com.dextrainig.MediaStore.entidades.Venda;
import br.com.dextrainig.MediaStore.services.ClienteService;
import br.com.dextrainig.MediaStore.services.MusicaService;
import br.com.dextrainig.MediaStore.services.VendaService;
     
     
    public class MenuVenda extends MenuBase {
     
            ClienteService clienteService = new ClienteService();
            MusicaService musicaService = new MusicaService();
            VendaService vendaService = new VendaService();
           
            @Override
            public void executar() throws IOException {
                    int op;
                    do {
                            limparTela();
                            System.out.println("-----------------------------");
                            System.out.println("Clientes:");
                            System.out.println("1\t-\tVender");
                            System.out.println("2\t-\tTotal por Cliente");
                            System.out.println();
                            System.out.println("0\t-\tVoltar");
                            System.out.print("Escolha sua opcao: ");
                            op = reader.read();
                    } while (op < 48 || op > 53);
                    reader.readLine();
                    char opcao = (char) op;
                    switch (opcao) {
                    case '1':
                            vender();
                            break;
                    case '2':
                    		consultaTotal();
                            break;
                    case '3':
                            break;
                    case '4':
                            break; 
                    case '5':
                            break;
                    default:
                            break;
                    }
            }
            
            public void consultaTotal(){
            	
            	Cliente cliente = null;
            	Long id = null;

            	cliente = pedirCliente();

            	BigDecimal total = vendaService.consultaTotalPorCliente(cliente.getId());
            	
            	System.out.println("Total cliente "+cliente.getNome()+" = R$"+total);
            			
            }
           
            public void vender() throws IOException {
                    Cliente cliente = pedirCliente();
                   
                    Venda venda = new Venda();
                    venda.setCliente(cliente);
                   
                    do {
                            Produto produto = pedirProduto();
                           
                            ItemVenda itemVenda = new ItemVenda();
                            itemVenda.setProduto(produto);
                            itemVenda.setQtde(1);
                           
                            venda.getItens().add(itemVenda);
                    } while (confirmacao("Adicionar outro produto? (s/n)"));
                   
                    venda.setData(new Date());
                   
                    BigDecimal total = BigDecimal.ZERO;
                    for (ItemVenda itemVenda : venda.getItens()) {
                            total = total.add(itemVenda.getProduto().getPreco().multiply(new BigDecimal(itemVenda.getQtde())));
                    }
                    venda.setTotal(total);
                   
                    vendaService.persist(venda);
            }
     
            private Produto pedirProduto() throws IOException {
                    Produto produto = null;
                    int op;
                    do {
                            System.out.println("Selecione o produto:");
                            System.out.println("1\t-\tMusica");
                            System.out.println("2\t-\tFilme");
                            System.out.println("3\t-\tLivro");
                            op = reader.read();reader.skip(1L);
                    } while (op < 48 || op > 53);
                    switch (op) {
                    case '1':
                            produto = pedirMusica();
                            break;
                    case '2':
                            //TODO: pedir Filme
                            break;
                    case '3':
                            //TODO: pedir Livro
                            break;
                    default:
                            break;
                    }
                    return produto;
            }
     
            private Musica pedirMusica() {
                    Musica musica = null;
                    do {
                            Long idMusica = pedirLong("Digite o id da musica: ");
                            try {
                                    musica = musicaService.findById(idMusica);
                            } catch (NoResultException e) {
                                    System.out.println("Musica nao encontrada");
                            }
                    } while (musica == null);
                    return musica;
            }
     
            private Cliente pedirCliente() {
                    Cliente cliente = null;
                                   
                    do {
                            Long idCliente = pedirLong("Digite o id do cliente: ");
                            try {
                                    cliente = clienteService.findById(idCliente);
                            } catch (NoResultException e) {
                                    System.out.println("Cliente nao encontrado");
                            }
                    } while (cliente == null);
                    return cliente;
            }
           
     
    } 

