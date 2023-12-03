package Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {

        String pattern = ".ox";
        String inputSequence = "The quick brown fox jumps over the lazy ox.";

        System.out.println("regex = " + pattern);
        System.out.println("input = " + inputSequence);

        Pattern firstPattern = Pattern.compile(pattern);
        Matcher firstMatcher = firstPattern.matcher(inputSequence);

        String wtf = "babaox";

        Matcher secondMatcher = firstPattern.matcher(wtf);
        System.out.println(secondMatcher.find());

            System.out.println(firstMatcher.groupCount());
        while (firstMatcher.find()) {
            System.out.println("Found [" + firstMatcher.group() + "] starting at "
                    + firstMatcher.start() + " and ending at " + (firstMatcher.end() - 1));
        }


        Pattern secondPattern = Pattern.compile(".x");
        Matcher thirdMatcher = secondPattern.matcher("dox ");
        System.out.println(thirdMatcher.lookingAt() + " lookingAt"); //????????????
//            firstMatcher.reset();
        System.out.println(thirdMatcher.find() + " find");

        boolean waitingValue = Pattern.matches(".ox", "kox");
        System.out.println(waitingValue);


        List progLangs = Arrays.asList("apl", "basic", "c", "c++", "c#", "cobol"
                , "java", "javascript", "perl", "python", "scala");
        Pattern p = Pattern.compile("^c");
        progLangs.stream().filter(p.asPredicate()).forEach(System.out::print);
        System.out.println();


        String waitingForSplit = "dewfewfwefwef wfg42gf rg34fg34kj34 9t3";

        List<String> splitted = List.of(waitingForSplit.split(" ", 3));
        System.out.println(splitted.size());
        System.out.println(splitted);

//        Pattern p = Pattern.compile("(cat)"); ???????????????????????????????
//        Matcher m = p.matcher("one cat, two cats, or three cats on a fence");
//        StringBuffer sb = new StringBuffer();
//        while (m.find())
//            m.appendReplacement(sb, "$1erpillar");
//        m.appendTail(sb);
//        System.out.println(sb);

        var m = "one cat, two cats, or three cats on a fence";
        System.out.println(m.replaceAll("cat", "caterpillar"));





    }
//    public int foo(int ... a){
//        System.out.println(Arrays.toString(a));
//        System.out.println(new int[Integer.MAX_VALUE]);
//        return 12;
//    }
}