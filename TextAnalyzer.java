import java.io.*;

public class TextAnalyzer
{
  public static void main(String[] args)
  {
    System.out.println("" + countCharacters("test.txt"));
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
