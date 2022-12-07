package Model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//classe com método para captura de texto de entrada
public class CapturaDeTxt {

	//método para leitura
	public static String leitorTxt(String caminho) {

		Path origem = Paths.get(caminho);
		String aux = null;

		try {
			byte[] texto = Files.readAllBytes(origem);
			aux = new String(texto);
			System.out.println("Arquivo carregado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao carregar arquivo!");
		}
		return aux;
	}
}
