package operations;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class CurryEvaluator implements Evaluator {
    @Override
    public SExpression eval(SExpression sExpression, Environment environment) {
        sExpression = sExpression.getTail();

        Function function = (Function) sExpression.eval(environment);
        IdentifierAtom[] identifierAtoms = function.getLambda().getArgumentNames();
        return null;
    }
}
