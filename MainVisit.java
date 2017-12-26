

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;   
import java.lang.Math;

public class MainVisit{
    private static class Visitor extends JCalcBaseVisitor<Integer>{
        @Override
        public Integer visitMulDiv(JCalcParser.MulDivContext context){
            int lhs = visit(context.expr(0));
            int rhs = visit(context.expr(1));
            if(context.op.getType() == JCalcParser.MUL){
                return lhs * rhs;
            }
            else{
                return lhs / rhs;
            }
        }

        @Override 
        public Integer visitSquare(JCalcParser.SquareContext context) { 
            int lhs = visit(context.expr(0));
            int rhs = visit(context.expr(1));
            return (int)Math.pow((double)lhs, (double)rhs);
        }


        @Override 
        public Integer visitParent(JCalcParser.ParentContext context) 
        { 
            return visit(context.expr());
        }


        @Override
        public Integer visitAddSub(JCalcParser.AddSubContext context){
            int lhs = visit(context.expr(0));
            int rhs = visit(context.expr(1));
            if(context.op.getType() == JCalcParser.ADD){
                return lhs + rhs;
            }
            else{
                return lhs - rhs;
            }
        }

        @Override   
        public Integer visitInt(JCalcParser.IntContext context){
            return Integer.valueOf(context.INT().getText());
        }
    }

    public static void main(String[] args) throws Exception {
        // String inputFile = null;
        // if ( args.length>0 ) inputFile = args[0];
        // InputStream is = System.in;
        // if ( inputFile!=null ) is = new FileInputStream(inputFile);

        // InputStream is = System.in;
        Scanner stream = new Scanner(System.in);
        // stream.
        ANTLRInputStream input = new ANTLRInputStream(stream.nextLine());
        JCalcLexer lexer = new JCalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //System.out.println(tokens.getText());

        JCalcParser parser = new JCalcParser(tokens);
        ParseTree tree = parser.expr(); // parse

        Visitor eval = new Visitor();
        System.out.println(eval.visit(tree));
    }
}

