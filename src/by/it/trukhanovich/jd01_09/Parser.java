package by.it.trukhanovich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc (String expression){
        String [] parts=expression.split(Patterns.OPERANIONS,2);
        if (parts.length!=2) {
            //TODO expression
            return null;
        }
        Var left=Var.createVar(parts[0]);
        Var right=Var.createVar(parts[1]);
        if (left==null||right==null){
            return null;
        }
        Pattern patternOperation= Pattern.compile(Patterns.OPERANIONS);
        Matcher matcherOperation=patternOperation.matcher(expression);
        if (matcherOperation.find()){
            String operation= matcherOperation.group();
            switch (operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
                default: return null;
            }
        }
        return null;
    }
}
