package operations;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.SExpression;

import java.util.function.LongBinaryOperator;

public abstract class NumberEvaluator implements Evaluator {


    public NumberEvaluator() {
        super();
    }

    public boolean compare(final SExpression sExpression, final Environment environment, final LongBinaryOperator operator) {
        final Long firstLong;
        final Long secondLong;
        final SExpression toCheck = sExpression.getTail();
        final SExpression first = toCheck.getHead().eval(environment);
        final SExpression second = toCheck.getTail().getHead().eval(environment);

        if (first instanceof IntegerAtom) {
            firstLong = ((IntegerAtom) first).getValue();
        } else {
            firstLong = ((DecimalAtom) first).getValue().longValue();
        }

        if (second instanceof IntegerAtom) {
            secondLong = ((IntegerAtom) second).getValue();
        } else {
            secondLong = ((DecimalAtom) second).getValue().longValue();
        }

        return operator.applyAsLong(firstLong, secondLong) == 1;
    }
}
