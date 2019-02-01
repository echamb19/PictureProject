package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void zeroRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int width = pixels[0].length;
	  for(int row = 0; row < pixels.length; row++)
		  {
		  	for (int col = 0; col < width; col++)
		  	{
		  		pixels[row][col].setRed(0);
		 // ^This^ and VThisV do the same thing in different ways
//		  		Pixel tempPixel = pixels[row][col];  
//		  		tempPixel.setRed(0);
		  	}
		  }
  }
  
  public void zeroGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
		  {
		  	for(int col = 0; col < pixels[0].length; col++)
		  	{
		  		pixels[row][col].setGreen(0);
		  	}
		  }
  }
  
  public void allGreen()
  {
	  Pixel[][] pixels = this.getPixels2D(); 
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setRed(0);
			  pixels[row][col].setBlue(0);
		  }
	  }
  }
  
  public void allBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setRed(0);
			  pixels[row][col].setGreen(0);
		  }
	  }
  }
  
  public void allRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setGreen(0);
			  pixels[row][col].setBlue(0);
		  }
	  }
  }
  
  public void halfAllButBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  int red = pixels[row][col].getRed();
			  int green = pixels[row][col].getGreen(); 
			  pixels[row][col].setRed(red/2);
			  pixels[row][col].setGreen(green/2);
		  }
	  }
  }
  
  public void halfAllButRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[00].length; col++)
		  {
			  int blue = pixels[row][col].getBlue();
			  int green = pixels[row][col].getGreen();
			  pixels[row][col].setBlue(blue/2);
			  pixels[row][col].setGreen(green/2);
		  }
	  }
  }
  
  public void halfAllButGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  int blue = pixels[row][col].getBlue();
			  int red = pixels[row][col].getRed();
			  pixels[row][col].setBlue(blue/2);
			  pixels[row][col].setRed(red/2);
		  }
	  }
  }
  
  /** Method that mirrors the picture from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture from right to left */
  public void mirrorVerticalReverse()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel rightPixel = null;
	  Pixel leftPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels.length; col++)
		  {
			  rightPixel = pixels[row][col];
			  leftPixel = pixels[row][width - 1 - col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  /** Method that mirrors the picture from bottom to top */
  public void mirrorHorizontalReverse()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topPixel = null; 
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for(int col = 0; col < pixels[0].length; col++)
	  {
		  for(int row = 0; row < pixels.length; row++)
		  {
			  bottomPixel = pixels[row][col];
			  topPixel = pixels [height - 1 - row][col]; 
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
  }

  /** Method that mirrors the picture from top to bottom */
  public void mirrorHorizontal()
  {
	Pixel [][] pixels = this.getPixels2D();
	Pixel topPixel = null;
	Pixel bottomPixel = null;
	int height = pixels.length;
	for (int col = 0; col < pixels[0].length; col++)
	{
	  for (int row = 0; row < height / 2; row++)
	  {
		topPixel = pixels[row][col];
  		bottomPixel = pixels [height - 1 - row][col];
		bottomPixel.setColor(topPixel.getColor());  			
	  }
	}
  }
  
  /** Method that picks a random way to mirror it */
  public void maybeMirror()
  {
	  int num = (int) (5 * Math.random());
	  
	  if(num == 1)
	  {
		  this.mirrorHorizontal();
	  }
	  if(num == 2)
	  {
		  this.mirrorVertical();
	  }
	  if(num == 3)
	  {
		  this.mirrorHorizontalReverse();
	  }
	  if(num == 4)
	  {
		  this.mirrorVerticalReverse();
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** Method that green-screens a color in a picture */
  public void chromakey(Picture replacement, Color changeColor)
  {
	  Pixel [][] mainPixels = this.getPixels2D();
	  Pixel [][] replacementPixels = replacement.getPixels2D();
	  
	  for (int row = 0; row < mainPixels.length; row++)
	  {
		  for (int col = 0; col < mainPixels[0].length; col++)
		  {
			  if (mainPixels[row][col].colorDistance(changeColor) < 10)
			  {
				  mainPixels[row][col].setColor(replacementPixels[row][col].getColor());
			  }
		  }
	  }
  }
  
  /** Multiply all the birds */
  public void mirrorGull() 
  {
	  int mirrorPoint = 350;
	  Pixel leftPixel = null; 
	  Pixel rightPixel = null; 
	  //int count = 0;
	  Pixel [][] pixels = this.getPixels2D();
	  
	  for (int row = 225; row < 325; row++)
	  {
		  for (int col = 225; col < mirrorPoint; col++)
			  {
			  	leftPixel = pixels[row][col];
			  	rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
			  	rightPixel.setColor(leftPixel.getColor());
			  }
	  }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  /** Shifts a picture horizontally */
  public void shiftLeftRight(int amount)
  {
	Pixel [][] pixels = this.getPixels2D();
	Picture temp = new Picture(this);
	Pixel[][] copied = temp.getPixels2D();
	
	int shiftedValue = amount; 
	int width = pixels[0].length; 
	
	for (int row = 0; row < pixels.length; row++)
	{
		for (int  col = 0; col < pixels[0].length; col++)
		{
			shiftedValue = (col + amount) % width;
			if (amount < 0)
			{
				shiftedValue = ((col + amount) % width + width) % width;
			}
			copied[row][col].setColor(pixels[row][shiftedValue].getColor());
		}
	}
	
	for (int row = 0; row < pixels.length; row++)
	{
		for (int col = 0; col < pixels[0].length; col++)
		{
			pixels[row][col].setColor(copied[row][col].getColor());
		}
	}
  }
  
  /** Shifts a picture vertically */
  public void shiftUpDown(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel [][] copied = temp.getPixels2D();
	  
	  int shiftedValue = amount; int height = pixels.length; 
	  
	  for (int row = 0; row < pixels.length; row++) 
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  shiftedValue = (row + amount) % height;
			  copied [row][col].setColor(pixels[shiftedValue][col].getColor());
		  }
	  }
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setColor(copied[row][col].getColor());
		  }
	  }
  }
 
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
//    Picture flower1 = new Picture("flower1.jpg");
//    Picture flower2 = new Picture("flower2.jpg");
	  Picture seagull = new Picture("seagull.jpg");
    this.copy(seagull,0,0);
    this.copy(seagull,100,0);
    this.copy(seagull,200,0);
    Picture seagullNoBlue = new Picture(seagull);
    seagullNoBlue.zeroBlue();
    this.copy(seagullNoBlue,300,0);
    this.copy(seagull,400,0);
    this.copy(seagull,500,0);
    //this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  /** Mirrors a picture at a randomly selected point in the picture */
  public void mirrorRandom()
  {
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
//	  Pixel topPixel = null;
//	  Pixel bottomPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  int height = pixels.length;
	  int width = pixels[0].length; 
	  int widthMirrorPoint = (int) ((width - 1) * Math.random());
	  int heightMirrorPoint = (int) ((height - 1) * Math.random());

	  for (int row = heightMirrorPoint; row < pixels.length; row++)
	  {
		  for (int col = widthMirrorPoint; col < pixels[0].length; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][(widthMirrorPoint - col + widthMirrorPoint)]; 
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }

  }

  /** Makes a pixel in a picture a random color */
  public void randomPixelsColor()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int height = pixels.length;
	  int width = pixels[0].length; 
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int pix = (int) (Math.random() * width);

		for(int row = 0; row < height; row++)
		{

		}
  }
  
  /* Makes a picture have a random color change */
  public void glitchy()
  {
	  int num = (int) (6 * Math.random());

	  if(num == 0)
	  {
		  this.allBlue();
	  }
	  if(num == 1)
	  {
		  this.allGreen();
	  }
	  if(num == 2)
	  {
		  this.allRed();
	  }
	  if(num == 3)
	  {
		  this.zeroBlue();
	  }
	  if(num == 4)
	  {
		  this.zeroGreen();
	  }
	  if(num == 5)
	  {
		  this.zeroRed();
	  }
	  
//	  this.mirrorRandom();
}
  
  /* Makes a picture halve 2 of three colors randomly */
  public void pickAHalf()
  {
	  int num = (int) (5 * Math.random());
	  
	  if(num == 1)
	  {
		  this.halfAllButBlue();
	  }
	  if(num == 2)
	  {
		  this.halfAllButRed();
	  }
	  if(num == 3)
	  {
		  this.halfAllButGreen();
	  }
	  if(num == 4)
	  {
		  
	  }
	  
  }

  /** Hides a picture inside another picture */
  public void hidePicture(Picture hidden)
  {
	  Pixel[][] pixels = this.getPixels2D(); 
	  Pixel[][] hiddenPixels = hidden.getPixels2D(); 
	  
	  for (int row = 0; row < pixels.length && row < hiddenPixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length && col < hiddenPixels[0].length; col++)
		  {
			  if (hiddenPixels[row][col].colorDistance(Color.WHITE) > 5)
			  {
				  if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 != 1)
					  {
					  		pixels[row][col].setRed(pixels[row][col].getRed() - 1);
					  }
			  }
			  else if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 == 1)
			  {
				  pixels[row][col].setRed(pixels[row][col].getRed() - 1);
			  }
		  }
	  }
  }
  
  /** Takes a picture and searches for a hidden picture within */
  public void revealPicture() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  if(pixels[row][col].getRed() > 0  && pixels[row][col].getRed() % 2 != 1)
			  {
				  pixels[row][col].setColor(Color.RED); 
			  }
			  else if (pixels[row][col].getRed() % 2 == 1)
			  {
				  pixels[row][col].setColor(Color.CYAN);
			  }
		  }
	  }
  }
  
  /** The final glitching thing that will glitch things */
  public void glitchify()
  {
	  this.mirrorRandom();
	  this.explore();
	  this.mirrorHorizontal();
	  this.explore();
	  this.glitchy();
	  this.explore();
	  this.pickAHalf();
	  this.explore();
	  this.maybeMirror();
	  this.explore();
	  this.shiftLeftRight(50);
	  this.explore();
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    Picture seagull = new Picture("seagull.jpg");
//    beach.explore();
//    beach.zeroBlue();
//    beach.explore();
//    beach.zeroRed();
//    beach.explore();
//    beach.mirrorHorizontal();
//    beach.explore();
//    seagull.explore();
//    seagull.mirrorGull();
//    seagull.explore();
//    beach.explore();
//    beach.shiftLeftRight(-800);
//    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
