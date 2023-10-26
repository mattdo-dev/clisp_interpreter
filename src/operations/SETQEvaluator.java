package operations;

import main.lisp.evaluator.AbstractEvaluator;
import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class SETQEvaluator extends AbstractEvaluator {
    @Override
    public SExpression eval(SExpression sExpression, Environment environment) {
        IdentifierAtom identifierAtom = (IdentifierAtom) sExpression.getTail().getHead();
        SExpression value = sExpression.getTail().getTail().getHead().eval(environment);
        environment.assign(identifierAtom, value);
        return value;
    }
}
