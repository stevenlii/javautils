package com.paymoon.demo.ping;
import java.io.*;
import java.util.*;
 
/**
 * A Java ping class.
 * Created by Alvin Alexander, devdaily.com.
 */
public class JavaPingExampleProgram
{
 
  public static void main(String args[]) 
  throws IOException
  {
    // create the ping command as a list of strings
    JavaPingExampleProgram ping = new JavaPingExampleProgram();
    List<String> commands = new ArrayList<String>();
    commands.add("ping");
    commands.add("-n");
    commands.add("10");
    commands.add("www.baidu.com");
    ping.doCommand(commands);
  }
 
  /**
   * Provide the command you want to run as a List of Strings. Here's an example:
   * 
   * List<String> commands = new ArrayList<String>();
   * commands.add("/sbin/ping");
   * commands.add("-c");
   * commands.add("5");
   * commands.add("www.google.com");
   * exec.doCommand(commands);
   * 
   * @param command The command you want to execute, provided as List<String>.
   * @throws IOException This exception is thrown so you will know about it, and can deal with it.
   */
  public void doCommand(List<String> command) 
  throws IOException
  {
    String s = null;
     
    ProcessBuilder pb = new ProcessBuilder(command);
    Process process = pb.start();
 
    BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
    BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
 
    // read the output from the command
    System.out.println("Here is the standard output of the command:\n");
    while ((s = stdInput.readLine()) != null)
    {
      System.out.println(s);
    }
 
    // read any errors from the attempted command
    System.out.println("Here is the standard error of the command (if any):\n");
    while ((s = stdError.readLine()) != null)
    {
      System.out.println(s);
    }
  }
   
}