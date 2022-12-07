package Model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

//classe para gerar arquivos de texto
public class GeradorDeTxt {

	//gerar arquivo de texto com inteiros, simulando dados
	public static void geradorTxt (String caminho, int tm, int qt) {

		String texto = methods.geraRandom(tm, qt);

		try(FileWriter criadorDeTxt = new FileWriter(caminho);
				BufferedWriter buffer = new BufferedWriter(criadorDeTxt);
				PrintWriter escritorDeTxt = new PrintWriter(buffer);)

		{
			escritorDeTxt.append(texto);
			System.out.println("Arquivo gerado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao gerar arquivo!");
		}
	}

	//gerar um arquivo de texto a partir de uma string
	public static void geradorTxt (String caminho, String texto) {

		try(FileWriter criadorDeTxt = new FileWriter(caminho);
				BufferedWriter buffer = new BufferedWriter(criadorDeTxt);
				PrintWriter escritorDeTxt = new PrintWriter(buffer);)

		{
			escritorDeTxt.append(texto);
			System.out.println("Arquivo gerado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao gerar arquivo!");
		}
	}

}
