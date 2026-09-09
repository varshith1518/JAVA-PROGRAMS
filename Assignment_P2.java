public class Assignment_P2 {

    public static void analyzeString(String sentence, char targetChar) {
        if (sentence == null || sentence.isBlank()) {
            System.out.println("Input sentence is empty or null.\n");
            return;
        }

        String trimmedSentence = sentence.strip();

        
        String[] words = trimmedSentence.split("\\s+");
        int wordCount = words.length;

        
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        
        int firstCharIndex = trimmedSentence.indexOf(targetChar);
        int lastCharIndex = trimmedSentence.lastIndexOf(targetChar);

        
        int comparison = firstWord.compareTo(lastWord);

        
        char firstChar = trimmedSentence.charAt(0);
        int asciiVal = firstChar;

        System.out.println("Input Sentence                  : \"" + sentence + "\"");
        System.out.println("Word Count                      : " + wordCount);
        System.out.println("First Word                      : " + firstWord);
        System.out.println("Last Word                       : " + lastWord);
        System.out.println("First '" + targetChar + "' index                : " + firstCharIndex);
        System.out.println("Last '" + targetChar + "' index                 : " + lastCharIndex);
        System.out.println("Comparison (first vs last word) : " + comparison);
        System.out.println("First Char ASCII Value          : " + asciiVal + "\n");
    }

    public static void main(String[] args) {
        String sampleSentence = " Java is fun and Java is powerful ";
        analyzeString(sampleSentence, 'J');
    }
}