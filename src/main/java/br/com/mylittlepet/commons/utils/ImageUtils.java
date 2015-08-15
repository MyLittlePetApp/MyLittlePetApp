package br.com.mylittlepet.commons.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Encoder;

public class ImageUtils {

	public static BufferedImage recuperarImagemDiretorio(final String diretorio) {
		try {
			return ImageIO.read(new File(diretorio));
		} catch (IOException e) {
			return null;
		}
	}

	public static byte[] converterImageEmArray(final BufferedImage imagem, final String extensaoArquivo) {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] imageInByte = null;
		try {
			ImageIO.write(imagem, extensaoArquivo, baos);
			baos.flush();
			imageInByte = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
			}
		}

		return imageInByte;
	}

	public static byte[] converterImageEmArray(final String imagem, final String extensaoArquivo) {
		return converterImageEmArray(recuperarImagemDiretorio(imagem), extensaoArquivo);
	}
	
	public static String converterByteEmStringBASE64(final byte[] arrayBytes) {
		final BASE64Encoder encoder = new BASE64Encoder();  
		return encoder.encodeBuffer(arrayBytes); 
	}
	
	public static String converterImagemEmStringBASE64(final String diretorioImagem, final String extensaoImagem) {
		return converterByteEmStringBASE64(converterImageEmArray(diretorioImagem, extensaoImagem));
	}
	
	public static String converterImagemEmStringBASE64(final String diretorioImagem) {
		return converterByteEmStringBASE64(converterImageEmArray(diretorioImagem, recuperarExtensaoArquivo(diretorioImagem)));
	}
	
	// TODO VER TRATAMENTO PARA JPEG
	public static String recuperarExtensaoArquivo(final String arquivo) {
		return arquivo.substring(arquivo.length() - 3) ;
	}
	
	public static byte[] converterStringBASE64EmArrayBytes(final String stringBase64) {
		try {
			return new sun.misc.BASE64Decoder().decodeBuffer(stringBase64);
		} catch (IOException e) {
			return null;
		} 
	}
	
	public static void salvarImagemDiretorio(final String diretorio, final byte[] arquivo) {
		try {
			final FileOutputStream fos = new FileOutputStream(diretorio);
			fos.write(arquivo);  
			FileDescriptor fd = fos.getFD();  
			fos.flush();  
			fd.sync();  
			fos.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static void salvarImagemDiretorio(final String diretorioNovo, final String imagemBase64) {
		salvarImagemDiretorio(diretorioNovo, converterStringBASE64EmArrayBytes(imagemBase64));
	}
	
}