package operations;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.NilAtomFactory;
import main.lisp.parser.terms.SExpression;

public class OrEvaluator extends LogicalEvaluator {
    @Override
    public SExpression eval(final SExpression sExpression, final Environment environment) {
        if (!sExpression.isList()) {
            return NilAtomFactory.newInstance();
        }

        SExpression toCheck = sExpression.getTail();
        SExpression heads = null;

        while (!toCheck.isNIL()) {
            heads = toCheck.getHead().eval(environment);
            toCheck = toCheck.getTail();
            if (!heads.isNIL()) {
                return heads;
            }
        }

        return NilAtomFactory.newInstance();
    }
}

