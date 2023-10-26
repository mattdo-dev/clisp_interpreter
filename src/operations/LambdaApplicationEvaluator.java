package operations;

import main.lisp.evaluator.BasicExpressionEvaluator;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.SExpression;

public class LambdaApplicationEvaluator extends BasicExpressionEvaluator {
    @Override
    public SExpression eval(SExpression sExpression, Environment environment) {
        if (sExpression.getHead().isAtom()) {
            return super.eval(sExpression, environment);
        }

        Lambda lambda = (Lambda) sExpression.getHead().eval(environment);

        return LambdaHelperEvaluator.eval(lambda, sExpression, environment);
    }
}
