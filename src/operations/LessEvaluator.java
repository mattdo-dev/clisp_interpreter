package operations;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.NilAtomFactory;
import main.lisp.parser.terms.TAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;

import java.util.function.LongBinaryOperator;

public class LessEvaluator extends NumberEvaluator {
    private final LongBinaryOperator operator = (a, b) -> a < b ? 1 : 0;

    @Override
    public SExpression eval(final SExpression sExpression, final Environment environment) {
        if (compare(sExpression, environment, operator)) {
            return TAtomicExpressionFactory.newInstance();
        } else {
            return NilAtomFactory.newInstance();
        }
    }
}
