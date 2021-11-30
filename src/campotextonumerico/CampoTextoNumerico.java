package campotextonumerico;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CampoTextoNumerico extends TextField{
    
    final static Label label = new Label();
    
    public CampoTextoNumerico(){
        
        final TextField txf = new TextField()
        {                  
            @Override
            public void replaceText(int start, int end, String text) 
            {
                if (!text.matches("[a-z, A-Z]")) 
                {
                    super.replaceText(start, end, text);
                }
                label.setText("Enter a numeric value");
            }
            
            @Override
            public void replaceSelection(String text) 
            {
                if (!text.matches("[a-z, A-Z]")) 
                {
                    super.replaceSelection(text);
                }
            }
        };
    }
}



