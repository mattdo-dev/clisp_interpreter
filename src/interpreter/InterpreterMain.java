package interpreter;

import atoms.InterpreterIdentifierAtom;
import environment.InterpreterEnvironment;
import main.Main;
import main.lisp.evaluator.ExpressionEvaluatorFactory;
import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtomFactory;
import operations.LambdaApplicationEvaluator;

public class InterpreterMain {
    public static void main(final String[] args) {
        ExpressionFactory.setClass(SExpressions.class);
        OperationsRegister.registerAll();
        EnvironmentFactory.setClass(InterpreterEnvironment.class);
        IdentifierAtomFactory.setClass(InterpreterIdentifierAtom.class);
        ExpressionEvaluatorFactory.setClass(LambdaApplicationEvaluator.class);
        Main.main(args);
    }
}
