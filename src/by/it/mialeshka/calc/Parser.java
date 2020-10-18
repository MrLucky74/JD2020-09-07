package by.it.mialeshka.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression){
        String[] parts = expression.split(Patterns.OPERATION, 2);

        if (parts.length != 2){
            return null;
        }
        Var right = Var.createVar(parts[1]);
        if(expression.contains("=")){
            return Var.saveVar(parts[0], right);
        }
        Var left = Var.createVar(parts[0]);
        if (left == null || right == null) {
            return null;
        }
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()){
            String strOperation = matcherOperation.group();
            switch (strOperation){
                case ("+"):
                    return left.add(right);
                case ("-"):
                    return left.sub(right);
                case ("*"):
                  return left.mul(right);
                case ("/"):
                  return left.div(right);
            }
        }
        return null;
    }
}