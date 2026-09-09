public class Assignment_P1 {

    public static String normalizeAndValidate(String input) {
        if (input == null) {
            return "EMPTY_STRING";
        }

       
        String cleaned = input.strip();

        
        if (cleaned.isEmpty()) {
            return "EMPTY_STRING";
        }

       
        if (cleaned.equalsIgnoreCase("admin")) {
            return "RESERVED_WORD";
        }

        
        String replaced = cleaned.replace("_", " ");

       
        String lowerCaseStr = replaced.toLowerCase();
        if (lowerCaseStr.startsWith("temp") && lowerCaseStr.endsWith("user")) {
            return replaced.concat("_FLAGGED");
        }

        return replaced;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "temp_John_user",
            "  ADMIN  ",
            "   ",
            "  hello_world  ",
            null
        };

        for (String test : testCases) {
            System.out.println("Input  : \"" + test + "\"");
            System.out.println("Output : \"" + normalizeAndValidate(test) + "\"\n");
        }
    }
}