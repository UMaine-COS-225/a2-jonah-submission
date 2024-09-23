import java.io.*;
import java.util.HashMap;

public class TextAnalyzer
{
  public static void main(String[] args)
  {
    //TODO: Finish main method
    //main method in use for testing purposes only at this point
    System.out.println("" + countCharacters("test.txt"));
    System.out.println("" + countWords("test.txt"));
    System.out.println("" + countLines("test.txt"));
    writeCharacterFrequency(countCharacterFrequency("test.txt"), "test2.txt");
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

  public static int countWords(String fileName)
  {
    int result = 0;
    String contents = getContents(fileName);
    for (int i = 1; i < contents.length(); i++)
    {
      if ((contents.charAt(i-1) == ' ' ||
           contents.charAt(i-1) == '\n') &&
           contents.charAt(i) != ' ' &&
           contents.charAt(i) != '\n')
      {
        result++;
      }
    }
    if (contents.charAt(0) != ' ' &&
        contents.charAt(0) != '\n')
    {
      result++; //checking case for the first character starting a word
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

  public static HashMap<Character, Integer>
                  countCharacterFrequency(String fileName)
  {
    HashMap<Character, Integer> result = new HashMap<Character, Integer>();
    String contents = getContents(fileName);
    for (int i = 0; i < contents.length(); i++)
    {
      char currentChar = contents.charAt(i);
      if (result.containsKey(currentChar))
      {
        result.put(currentChar, result.get(currentChar) + 1);
      }
      else
      {
        result.put(currentChar, 1);
      }
    }
    return result;
  }

  public static HashMap<String, Integer> countWordFrequency(String fileName)
  {
    HashMap<String, Integer> result = new HashMap<String, Integer>();
    String contents = getContents(fileName);
    String word = "";
    for (int i = 0; i < contents.length(); i++)
    {
      if (contents.charAt(i) == ' ' || contents.charAt(i) == '\n')
      {
        if (word != "")
        {
          if (result.containsKey(word))
          {
            result.put(word, result.get(word) + 1);
          }
          else
          {
            result.put(word, 1);
          }
        }
        word = "";
      }
      else
      {
        word += contents.charAt(i);
      }
    }
    return result;
  }

  public static void writeCharacterFrequency(
      HashMap<Character, Integer> charFrequency, String fileName)
  {
    try
    {
      FileWriter writer = new FileWriter(fileName);
      for (Character charKey : charFrequency.keySet())
      {
        writer.write(charKey + "," + charFrequency.get(charKey) + "\n");
      }
      writer.close();
    }
    catch (IOException e)
    {
      System.out.println(
          "Something happened when trying to write to the file");
      e.printStackTrace();
    }
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
