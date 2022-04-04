package br.com.diegocordeiro.dscproject;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
		
	static public Date insereTipoData(String data, String  tipoFormato) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat(tipoFormato);		
		return formato.parse(data);		
	}
	
	public static String removerCaracteresEspeciais(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

}
