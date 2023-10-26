package operations;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class ListEvaluator extends UniqueEvaluator {
    @Override
    public SExpression eval(final SExpression sExpression, final Environment environment) {
        final SExpression toCheck = sExpression.getTail();
        if (toCheck.isNIL()) {
            return NilAtomicExpressionFactory.newInstance();
        } else {
            return ExpressionFactory.newInstance(toCheck.getHead().eval(environment), eval(toCheck, environment));
        }
    }
}
