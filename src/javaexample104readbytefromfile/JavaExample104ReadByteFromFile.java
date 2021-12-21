
package javaexample104readbytefromfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class JavaExample104ReadByteFromFile {

    
    public static void main(String[] args) {
        
        
        File workFolder = MyHepler.CreateWorkingFolder("myWorkingFolder");
        MyHepler.FolderCheck(workFolder);
        File fil = MyHepler.CreateWorkingFile(workFolder, "myFile.dat");
        MyHepler.FileCheck(fil);
        
        try{
            
            FileInputStream fis = new FileInputStream(fil);
            
            int myChar = fis.read();
            
            while(myChar != -1)
            {
                System.out.println(myChar + " " + (char)myChar);
                myChar = fis.read();
            }// end-while
            
            //******************************************************************
            //***** Read byte using large byte array ***************************
            System.out.println("---------------------------------------------");
            
            fis = new FileInputStream(fil);
            
            byte[] byteArray = new byte[1000];
            
            /*
            Returns:
            the total number of bytes read into the buffer, or -1 if there is no
            more data because the end of the stream has been reached.
            */
            int amount = fis.read(byteArray);
            System.out.println("Byte-array length: " + amount);
            
            for (int i = 0; i < amount; i++) {
                System.out.println((char)byteArray[i]);
            }
            
            // close
            fis.close();
        }// end-try
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
}
