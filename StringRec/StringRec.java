public class StringRec
{

	public static String decompress(String compressedText)
	{
            
            if (compressedText.length() == 1){
                return compressedText;
            }
            if (compressedText.length() > 1){
                char first = compressedText.charAt(0);
                char second = compressedText.charAt(1);
                if (Character.isDigit(first)){
                        if (Character.getNumericValue(first) == 1){
                            return Character.toString(second) + decompress(compressedText.substring(2));
                        }
                        else if (Character.getNumericValue(first) < 1){
                            return Character.toString(first) + decompress(compressedText.substring(1));
                        }
                        else if (Character.getNumericValue(first) > 1){
                            first--;
                            String temp = Character.toString(first) + Character.toString(second) + compressedText.substring(1);
                            return decompress(temp);
                        }
                }
                else {
                    return Character.toString(first) + decompress(compressedText.substring(1));
                }
            }
            return "";
	}
        
        public static void main (String [] args)
        {
            String j = "q9w5e2rt5y4qw2Er3T";
            System.out.println(decompress(j));
        }
}