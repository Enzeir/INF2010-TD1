import java.awt.PageAttributes.ColorType;

/**
 * Classe PixelMapPlus
 * Image de type noir et blanc, tons de gris ou couleurs
 * Peut lire et ecrire des fichiers PNM
 * Implemente les methodes de ImageOperations
 * @author : 
 * @date   : 
 */

public class PixelMapPlus extends PixelMap implements ImageOperations 
{
	/**
	 * Constructeur creant l'image a partir d'un fichier
	 * @param fileName : Nom du fichier image
	 */
	PixelMapPlus(String fileName)
	{
		super( fileName );
	}
	
	/**
	 * Constructeur copie
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(PixelMap image)
	{
		super(image); 
	}
	
	/**
	 * Constructeur copie (sert a changer de format)
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(ImageType type, PixelMap image)
	{
		super(type, image); 
	}
	
	/**
	 * Constructeur servant a allouer la memoire de l'image
	 * @param type : type d'image (BW/Gray/Color)
	 * @param h : hauteur (height) de l'image 
	 * @param w : largeur (width) de l'image
	 */
	PixelMapPlus(ImageType type, int h, int w)
	{
		super(type, h, w);
	}
	
	/**
	 * Genere le negatif d'une image
	 */
	public void negate()
	{
		// compl�ter
		for(int row = 0; row<getHeight(); row++)
		{
			for(int col = 0; col<getWidth(); col++) 
			{
				imageData[row][col] = imageData[row][col].Negative();
			}
		}
	}
	
	/**
	 * Convertit l'image vers une image en noir et blanc
	 */
	public void convertToBWImage()
	{
		// compl�ter
		for(int row = 0; row<getHeight(); row++)
		{
			for(int col = 0; col<getWidth(); col++) 
			{
				imageData[row][col] = imageData[row][col].toBWPixel();
			}
		}
		
	}
	
	/**
	 * Convertit l'image vers un format de tons de gris
	 */
	public void convertToGrayImage()
	{
		// compl�ter
		for(int row = 0; row<getHeight(); row++)
		{
			for(int col = 0; col<getWidth(); col++) 
			{
				imageData[row][col] = imageData[row][col].toGrayPixel();
			}
		}
		
	}
	
	/**
	 * Convertit l'image vers une image en couleurs
	 */
	public void convertToColorImage()
	{
		// compl�ter
		for(int row = 0; row<getHeight(); row++)
		{
			for(int col = 0; col<getWidth(); col++) 
			{
				imageData[row][col] = imageData[row][col].toColorPixel();
			}
		}
		
	}
	
	public void convertToTransparentImage()
	{
		// compl�ter
		for(int row = 0; row<getHeight(); row++)
		{
			for(int col = 0; col<getWidth(); col++) 
			{
				imageData[row][col] = imageData[row][col].toTransparentPixel();
			}
		}
		
	}
	
	
	/**
	 * Modifie la longueur et la largeur de l'image 
	 * @param w : nouvelle largeur
	 * @param h : nouvelle hauteur
	 */
	public void resize(int w, int h) throws IllegalArgumentException
	{
		if(w < 0 || h < 0)
			throw new IllegalArgumentException();
		
		// compl�ter
		int hRatio = getHeight()/h;
		int wRatio = getWidth()/w;
		
		AbstractPixel[][] tempImageData = new AbstractPixel[h][w];
		for(int row = 0; row< h; row++)
		{
			for(int col = 0; col< w; col++)
			{
				
				tempImageData[row][col] = imageData[row][col];
			}
		}
		imageData = tempImageData;
		height = h;
		width = w;
	}
	
	/**
	 * Insert pm dans l'image a la position row0 col0
	 */
	public void insert(PixelMap pm, int row0, int col0) throws IllegalArgumentException
	{
		// compl�ter
		if(row0 < 0 || col0 < 0)
			throw new IllegalArgumentException();
		
		for(int row = row0; row < pm.getHeight();row++)
		{
			for(int col = col0; col < pm.getWidth(); col++)
			{
				imageData[row][col] = pm.getPixel(row, col);
			}
		}
	}
	
	/**
	 * Decoupe l'image 
	 */
	public void crop(int h, int w) throws IllegalArgumentException
	{
		// compl�ter
		if(h < 0 || w < 0)
			throw new IllegalArgumentException();
		
		AbstractPixel[][] tempImageData = new AbstractPixel[h][w];
		
		for(int row = 0; row< getHeight(); row++)
		{
			for(int col = 0; col< getWidth(); col++)
			{
				tempImageData[row][col] = new BWPixel(true);
			}
		}
		
		for(int row = 0; row < h;row++)
		{
			for(int col = 0; col < w; col++)
			{
				tempImageData[row][col] = imageData[row][col];
			}
		}
		
		imageData = tempImageData;		
	}
	
	/**
	 * Effectue une translation de l'image 
	 */
	public void translate(int rowOffset, int colOffset)
	{
		// compl�ter
		AbstractPixel[][] tempImageData = whiteImage(getHeight(), getWidth());

		
		for(int row = 0; row < getHeight();row++)
		{
			for(int col = 0; col < getWidth(); col++)
			{
				tempImageData[row+rowOffset][col+ colOffset] = imageData[row][col];
			}
		}
		imageData = tempImageData;
		
	}
	
	
	private AbstractPixel[][] whiteImage(int endRow,int endCol)
	{
		AbstractPixel[][] tempImageData = new AbstractPixel[endRow][endCol];
		
		for(int row = 0; row < endRow; row++)
		{
			for(int col = 0; col < endCol; col++)
			{
				tempImageData[row][col] = new BWPixel(true);
			}
		}
		return tempImageData;
	}
	
}
