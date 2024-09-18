import java.io.*;

public class TextAnalyzer
{
  public static void main(String[] args)
  {
  }

  //TODO: Finish countCharacters
  public static int countCharacters(String fileName)
  {
    int result = -1;
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
    {
      String line = reader.readLine();
      String contents = "";
      while (line != null)
      {
      //TODO: Finish while loop to grab lines from fileName
      //and add them to contents
      }
      for (int i = 0; i < contents.length(); i++)
      {
        result++;
      }
    }
    catch (IOException e)
    {}
    //TODO: Finish try/catch block
    
    return result;
  }
}
