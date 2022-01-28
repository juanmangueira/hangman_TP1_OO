package hangman_TP1_OO;

//Importações
import java.util.Scanner; //Importando scanner

public class HangmanTP1_OO {

	//Limpa tela
	public static void limpaTela() {
		
		for (int i=0; i<7; i++) {
			System.out.println("\n");			
		}
	}
	
	//Impressão do menu principal
	public static int menuPrincipal() {
		int option;
		Scanner ler = new Scanner (System.in);
		System.out.println("=======MENU=======");
		System.out.println("1. Gerenciar Temas");
		System.out.println("2. Gerenciar Palavras");
		System.out.println("3. Jogar");
		System.out.println("4. Sair\n");
		System.out.print("Digite aqui o número desejado e pressione Enter: ");
		option = ler.nextInt(); //Leitura de opção do menu
		limpaTela();
		return option;
	}
	
	//Impressão Menu Gerenciar Temas
	public static int menuGerenciarTemas() {
		Scanner ler = new Scanner (System.in);
		int option;
		System.out.println("=======GERENCIAR TEMAS=======");
		System.out.println("1. Cadastrar um novo tema");
		System.out.println("2. Excluir um tema");
		System.out.println("3. Buscar um tema");
		System.out.print("Digite aqui o número desejado e pressione Enter: ");
		option = ler.nextInt();//Leitura de opção do menu 
		return option;
	}
	
	//Impressão Menu Gerenciar Palavras
	public static int menuGerenciarPalavras() {
		Scanner ler = new Scanner (System.in);
		int option;
		System.out.println("=======GERENCIAR PALAVRAS=======");
		System.out.println("1. Cadastrar uma nova palavra");
		System.out.println("2. Excluir uma palavra");
		System.out.println("3. Buscar uma palavra");
		System.out.println("4. Listagem de palavras");
		System.out.print("Digite aqui o número desejado e pressione Enter: ");
		option = ler.nextInt();//Leitura de opção do menu
		return option;
	}
	
	
	
	
	
	
	//Main
	public static void main(String[] args) { 
		int opcoes;
		int contadorTemas=0, contadorPalavras[]= new int [50];
		String bancoTemasPalavras[][] = new String [50][51]; //Banco de dados com os temas e respectivas palavras
		Scanner ler = new Scanner (System.in);
		
		while (true) {			
			//Contadores
			//Contador de temas
			for (int i=0; i<50; i++) {
				if (bancoTemasPalavras[i][0] != null) {
					contadorTemas++;
				}
			}
			//Contador de palavras
			for (int i=0; i<contadorTemas+1; i++) {
				for (int j=1; j<51; j++) {
					if (bancoTemasPalavras[i][j] != null) {
						contadorPalavras[i]++;
					}						
				}
			}
			
			opcoes = menuPrincipal();
			
			switch (opcoes){ //Menu funcional, com as opções propriamente ditas
			case 1: //Gerenciar Temas
				
				opcoes = menuGerenciarTemas();//Leitura de opção do menu 
				
				switch (opcoes) {//menu de opções de temas
				case 1: //Cadastrar um novo tema
					String verificaTema;
					do {
						System.out.println("Qual tema deseja cadastrar?");
						verificaTema = ler.next(); //recebe o tema a ser verificado
						for (int i=0; i<50; i++) { //Verificador de tema
							if (verificaTema.equals(bancoTemasPalavras[i][0])) { //caso seja igual a algum tema
								System.out.println("Este tema já foi registrado!");
								while (verificaTema.equals(bancoTemasPalavras[i][0])) {
									System.out.println("Qual tema deseja cadastrar?");
									verificaTema = ler.next(); //recebe o tema a ser verificado
								}					
							}
						} 
					} while (false); //laço de verificação
					System.out.println("Tema cadastrado com sucesso!");
					bancoTemasPalavras [contadorTemas][0] = verificaTema;
					break;
				case 2: //Excluir um tema
					System.out.println("=======EXCLUIR TEMAS=======");
					/*for (int i=0; i<50; i++) {
						Integer.toString(i);
						System.out.print(i+1 + " - ");
						System.out.println(bancoTemasPalavras[i][0]);						
					}
					System.out.print("Digite o número da opção desejada: ");
					opcoes = ler.nextInt();
					bancoTemasPalavras[opcoes][0] = null; //INCOMPLETO FAZER VERIFICAÇÃO SE HÁ PALAVRAS NO TEMA*/
					break;
				case 3: //Buscar um tema
					String buscaTema;
					boolean existeTema=false;
					System.out.println("=======BUSCAR TEMAS=======");
					System.out.print("Digite o tema a ser pesquisado: ");		
					buscaTema = ler.next();
					for (int i=0; i<(contadorTemas-1); i++) {
						if (buscaTema.equals(bancoTemasPalavras[i][0])) {
							existeTema = true;
						}
					}
					if (existeTema == true) {
						System.out.println("Este tema está na lista de temas cadastrados.");						
					} else {
						System.out.println("Este tema não está na lista de temas cadastrados.");						
					}
					break;
				default://Nenhuma das opções acima
					System.out.println("=======OPÇÃO INVÁLIDA=======");
					System.out.println("Digite uma opção válida!");
					break;
				}
				System.out.println("\n\n"); //pula linha
				break;
			case 2: //Gerenciar Palavras
				
				opcoes = menuGerenciarPalavras();
				switch (opcoes) {//menu de opções de palavras
				case 1: //Cadastrar uma nova palavra
					String verificaPalavra;
					System.out.println("=======CADASTRAR PALAVRAS=======");
					System.out.println("Primeiro escolha um tema:");
					for (int i=0; i<(contadorTemas-1); i++) {
						System.out.print(i + " - ");
						System.out.println(bancoTemasPalavras[i][0]);						
					}
					System.out.print("Digite o numero da opcao desejada: ");
					opcoes = ler.nextInt();
					do {
						System.out.println("Qual palavra deseja cadastrar?");
						verificaPalavra = ler.next(); //recebe a palavra a ser verificada
						for (int i=1; i<contadorPalavras[opcoes]; i++) {
							if (verificaPalavra.equals(bancoTemasPalavras[opcoes][i])) {
								System.out.println("Esta palavra já foi registrada!");
								while (verificaPalavra.equals(bancoTemasPalavras[opcoes][i])) {
									System.out.println("Qual palavra deseja cadastrar?");
									verificaPalavra= ler.next(); //recebe a palavra a ser verificada;
								}		
							}
						}
					} while (false); //laço de verificação
					System.out.println("Palavra cadastrada com sucesso!");
					bancoTemasPalavras [opcoes][contadorPalavras[opcoes+1]] = verificaPalavra;
					break;
				case 2: //Excluir uma palavra
					System.out.println("=======EXCLUIR PALAVRAS=======");
					
					/*System.out.println("Primeiro escolha um tema:");
					for (int i=0; i<51; i++) {
						Integer.toString(i);
						System.out.print(i+1 + " - ");
						System.out.println(bancoTemasPalavras[i][0]);						
					}
					System.out.print("Digite o numero da opcao desejada: ");
					
					opcoes = ler.nextInt();
					
					for (int i=1; i<51; i++) {
						Integer.toString(i);
						System.out.print(i + " - ");
						System.out.println(bancoTemasPalavras[opcoes][i]);						
					}
					System.out.print("Digite o número da opção desejada: ");
					int opcaoPalavra = ler.nextInt();
					bancoTemasPalavras[opcoes][opcaoPalavra+1] = null; //INCOMPLETO FAZER VERIFICAÇÃO SE HÁ PALAVRAS NO TEMA*/
					break;
				case 3: //Buscar uma palavra
					String buscaPalavra;
					boolean existePalavra=false;
					System.out.println("=======BUSCAR PALAVRA=======");
					System.out.print("Digite a palavra a ser pesquisada: ");		
					buscaPalavra = ler.next();
					
					
					for (int i=0; i<(contadorTemas-1); i++) {
						for (int j=1; j<51; j++) {
							if (buscaPalavra.equals(bancoTemasPalavras[i][j])) {
								existePalavra = true;
							}							
						}
					}
					if (existePalavra == true) {
						System.out.println("Esta palavra está na lista de palavras cadastradas.");						
					} else {
						System.out.println("Esta palavra não está na lista de palavras cadastradas.");						
					}
					break;
				case 4: //Listagem de palavras
					break;
				default://Nenhuma das opções acima
					break;
				}
				System.out.println("\n\n");//pula linha		
				break;
			case 3: //Jogar
				System.out.println("=======JOGAR=======");
				System.out.println("Funcionou! Este é o caso 3");
				System.out.println("\n\n");//pula linha
				break;
			case 4: //Sair
				System.out.println("=======SAÍDA=======");
				System.out.println("Encerrando o programa...\n");
				System.out.println("Muito obrigado pelo seu tempo!");
				System.exit(0); //encerramento do programa
				break;
				
			case 5:
				System.out.print("Temas: "+contadorTemas);
				System.out.println("\n\n");
				for (int i=0; i<(contadorTemas-1); i++) {
					System.out.print("Palavras: "+contadorPalavras[i]);
					System.out.println("\n\n");
				}
				System.out.println("\n\n");
				break;
			default: //Nenhuma das opções anteriores
				System.out.println("=======OPÇÃO INVÁLIDA=======");
				System.out.println("Ops! Você digitou uma opção inválida!");
				System.out.println("\n\n");//pula linha
				break;				
			}
			
		}

	}

}
