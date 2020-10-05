package by.it._akhmelev_.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression){
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length!=2){
            //TODO generate exception
            if (parts.length==1)
                return Var.createVar(expression);
            return null;
        }
        Var right=Var.createVar(parts[1]);
        if (expression.contains("=")){
            return Var.save(parts[0],right);
        }
        Var left=Var.createVar(parts[0]);
        if (left==null || right==null){
            return null;
        }
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()){
            String operation = matcherOperation.group();
            switch (operation ){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}