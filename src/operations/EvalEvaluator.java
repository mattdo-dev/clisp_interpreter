package operations;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.SExpression;

public class EvalEvaluator extends UniqueEvaluator {
    @Override
    public SExpression eval(final SExpression sExpression, final Environment environment) {
        return sExpression.getTail().getHead().eval(environment).eval(environment);
    }
}
