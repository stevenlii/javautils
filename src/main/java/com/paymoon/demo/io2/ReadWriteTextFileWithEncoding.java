package com.paymoon.demo.io2;
import java.io.*;
import java.util.Scanner;

/** 
 Read and write a file using an explicit encoding.
 JDK 1.5.
 Removing the encoding from this code will simply cause the 
 system's default encoding to be used instead.  
*/
public final class ReadWriteTextFileWithEncoding {

  /** Requires two arguments - the file name, and the encoding to use.  */
  public static void main(String... aArgs) throws IOException {
    String fileName = aArgs[0];
    String encoding = aArgs[1];
    ReadWriteTextFileWithEncoding test = new ReadWriteTextFileWithEncoding(
      fileName, encoding
    );
    test.write();
    test.read();
  }
  
  /** Constructor. */
  ReadWriteTextFileWithEncoding(String aFileName, String aEncoding){
    fEncoding = aEncoding;
    fFileName = aFileName;
  }
  
  /** Write fixed content to the given file. */
  void write() throws IOException  {
    log("Writing to file named " + fFileName + ". Encoding: " + fEncoding);
    Writer out = new OutputStreamWriter(new FileOutputStream(fFileName), fEncoding);
    try {
      out.write(FIXED_TEXT);
    }
    finally {
      out.close();
    }
  }
  
  /** Read the contents of the given file. */
  void read() throws IOException {
    log("Reading from file.");
    StringBuilder text = new StringBuilder();
    String NL = System.getProperty("line.separator");
    Scanner scanner = new Scanner(new FileInputStream(fFileName), fEncoding);
    try {
      while (scanner.hasNextLine()){
        text.append(scanner.nextLine() + NL);
      }
    }
    finally{
      scanner.close();
    }
    log("Text read in: " + text);
  }
  
  // PRIVATE 
  private final String fFileName;
  private final String fEncoding;
  private final String FIXED_TEXT = "But soft! what code in yonder program breaks?";
  
  private void log(String aMessage){
    System.out.println(aMessage);
  }
}