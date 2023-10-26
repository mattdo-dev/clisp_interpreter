package operations;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.NilAtomFactory;
import main.lisp.parser.terms.TAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class NotEvaluator extends LogicalEvaluator {
    @Override
    public SExpression eval(final SExpression sExpression, final Environment environment) {
        final SExpression toCheck = sExpression.getTail();
        final SExpression first = toCheck.getHead().eval(environment);

        if (first.isNIL()) {
            return TAtomicExpressionFactory.newInstance();
        } else {
            return NilAtomFactory.newInstance();
        }
    }
}