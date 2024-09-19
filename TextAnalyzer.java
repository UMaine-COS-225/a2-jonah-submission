import java.io.*;

public class TextAnalyzer
{
  public static void main(String[] args)
  {
    //main method in use for testing purposes only
    System.out.println("" + countCharacters("test.txt"));
    System.out.println("" + countLines("test.txt"));
  }

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

  public static int countLines(String fileName)
  {
    int result = 0;
    String contents = getContents(fileName);
    for (int i = 0; i < contents.length(); i++)
    {
      if (contents.charAt(i) == '\n')
      {
        result++;
      }
    }
    return result;
  }

  private static String getContents(String fileName)
  {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
    {
      String line = reader.readLine();
      String contents = "";
      while (line != null)
      {
        contents += line;
        contents += "\n";
        line = reader.readLine();
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
