package br.com.mylittlepet.commons.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.StringTokenizer;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtils {
	
	private static FTPClient ftp = null;
	public static String DIRETORIO_BASE = "MLP\\APP\\";
	
	static {
		ftp = new FTPClient();
	}
	
	public static String salvarImagemFTP(final String imagem, final String diretorio, final String nomeImagem) throws IOException {
		conectarFTP();
		final InputStream imagemStream = new ByteArrayInputStream(ImageUtils.converterStringBASE64EmArrayBytes(imagem));
		StringTokenizer st = new StringTokenizer(diretorio, "\\");
		while (st.hasMoreElements()) {
			final String dir = (String) st.nextElement();
			ftp.makeDirectory(dir);  
			ftp.changeWorkingDirectory(dir);
		}
		
		ftp.setFileType( FTPClient.BINARY_FILE_TYPE );  
		if (ftp.storeFile(nomeImagem, imagemStream)) {
			desconectarFTP();
			return diretorio.concat("\\").concat(nomeImagem);
		} else {
			desconectarFTP();
			return null;
		}
	}
	
	
	public static FTPClient conectarFTP() throws SocketException,	IOException {
		ftp.connect("179.188.20.39");
		 //verifica se conectou com sucesso!  
        if(FTPReply.isPositiveCompletion(ftp.getReplyCode()) ) {  
            ftp.login("jelastic-ftp", "hPxdKvqrmc");
        } else {  
        	desconectarFTP(); 
        } 
		return ftp;
	}
	
	public static void desconectarFTP() throws IOException {
		if(ftp != null) {
			ftp.logout();
			ftp.disconnect();
		}
	}
	

}
