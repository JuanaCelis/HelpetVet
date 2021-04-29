package utilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UploaderFontsResource {
	
	public UploaderFontsResource() {	
	}
	
	public static Font uploadFont(String path, int style, float size)throws FontFormatException, IOException {
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
		
		font = font.deriveFont(style, size);
		return font;
	}
	
	public static Font uploadFontTwo(String path, int style, float size)throws FontFormatException, IOException{
		
		Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		
		font.deriveFont(style, size);
		return font;
	}
}
