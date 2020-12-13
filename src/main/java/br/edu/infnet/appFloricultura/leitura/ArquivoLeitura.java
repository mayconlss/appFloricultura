package br.edu.infnet.appFloricultura.leitura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.edu.infnet.appFloricultura.exception.CorInvalidaException;
import br.edu.infnet.appFloricultura.exception.PesoInvalidoException;
import br.edu.infnet.appFloricultura.exception.SacoInvalidoException;
import br.edu.infnet.appFloricultura.business.Planta;
import br.edu.infnet.appFloricultura.business.Semente;
import br.edu.infnet.appFloricultura.business.Adubo;

public class ArquivoLeitura {

	public static void main(String[] args) {
		
		String dir = "C:/dev/workspace20E4/";
		String arq = "venda.txt";

		try {
			FileReader leitura = new FileReader(dir+arq);			
			BufferedReader in = new BufferedReader(leitura);
			
			FileWriter escrita = new FileWriter(dir+"out_"+arq);			
			BufferedWriter out = new BufferedWriter(escrita);

			String linha = in.readLine();
			
			while(linha != null) {
				
				String[] campos = linha.split(";");
				
				
				switch (campos[0].toUpperCase()) {
				case "P":
					Planta planta = new Planta(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
					planta.setRara(Boolean.valueOf(campos[4]));
					planta.setCor(campos[5]);
					
					out.write(planta.obterPrecoUnidade());
					break;

				case "S":
					Semente semente = new Semente(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
					semente.setPeso(Integer.valueOf(campos[4]));
					semente.setEmbalagem(campos[5]);

					out.write(semente.obterPrecoUnidade());					
					break;

				case "A":
					Adubo adubo = new Adubo(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
					adubo.setSaco(Integer.valueOf(campos[4]));
					adubo.setCompacto(Boolean.valueOf(campos[5]));

					out.write(adubo.obterPrecoUnidade());
					break;
					
				default:
					break;
				}

				linha = in.readLine();
			}

			in.close();
			leitura.close();
			
			out.close();
			escrita.close();
			
			System.out.println(args.length == 1 ? args[0] : "Feito!");
		} catch (IOException | CorInvalidaException | PesoInvalidoException | SacoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
