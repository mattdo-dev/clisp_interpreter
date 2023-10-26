package operations;

import main.lisp.evaluator.AbstractEvaluator;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.function.FunctionFactory;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.SExpression;

public class FunctionEvaluator extends AbstractEvaluator {
    @Override
    public SExpression eval(SExpression sExpression, Environment environment) {
        sExpression = sExpression.getTail();
        Lambda lambda = (Lambda) sExpression.getHead().eval(environment);
        return FunctionFactory.newInstance(lambda, environment);
    }
}
