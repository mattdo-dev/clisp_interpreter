package operations;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.NilAtomFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class CondEvaluator extends UniqueEvaluator {
    @Override
    public SExpression eval(final SExpression sExpression, final Environment environment) {
        SExpression expressions = sExpression.getTail();
        if (expressions.isNIL()) {
            // TODO: should return nil if there are no parameters.
            return expressions.eval(environment);
        }
        while (expressions != null && !expressions.isAtom()) {
            final SExpression expression = expressions.getHead();
            final SExpression result = expression.getHead().eval(environment);
            if (!result.isNIL() && expression.getTail().isNIL()) return result.eval(environment);
            else if (result instanceof TAtom) return expression.getTail().getHead().eval(environment);
            expressions = expressions.getTail();
        }
        return NilAtomFactory.newInstance();
    }
}
