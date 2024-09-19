import java.io.*;

public class TextAnalyzer
{
  public static void main(String[] args)
  {
  }

  //TODO: Finish countCharacters
  public static int countCharacters(String fileName)
  {
    int result = 0;
    String contents = getContents(fileName);
    for (int i = 0; i < contents.length(); i++)
    {
      result++;
    }
    return result;
  }

  //TODO: Finish getContents
  private static String getContents(String fileName)
  {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
    {
      String line = reader.readLine();
      String contents = "";
      while (line != null)
      {
        contents += line;
        line = reader.readLine();
      //TODO: Ensure getContents works as intended.
      }
      return contents;
    }
    catch (IOException e)
    {
      System.out.println("Something happened when trying to read the file.");
      e.printStackTrace();
      return "";
    }
  }
}
