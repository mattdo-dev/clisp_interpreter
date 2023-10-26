package interpreter;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.BasicExpression;

import java.util.List;
import java.util.Vector;

public class SExpressions extends BasicExpression {
    public SExpressions(final SExpression head, final SExpression tail) {
        super(head, tail);
    }

    @Override
    public SExpression eval(final Environment environment) {
        return super.eval(environment);
    }

    @Override
    public boolean isList() {
        return getTail().isList();
    }

    @Override
    public String toStringAsSExpressionDeep() {
        return parens(getHead().toStringAsSExpressionDeep() + dot() + getTail().toStringAsSExpressionDeep());
    }

    @Override
    public String toStringAsSExpression() {
        return parens(getHead().toString() + dot() + getTail().toString());
    }

    @Override
    public String toStringAsList() {
        return parens(toStringAsListHelperPublic());
    }

    @Override
    public String toStringAsListHelperPublic() {
        final Environment environment = EnvironmentFactory.newInstance();
        final Vector<String> vector = new Vector<>();
        SExpression current = this;
        while (current.isList()) {
            if (current.getHead() instanceof Evaluator) {
                vector.add((current.eval(environment).toString()));
            } else {
                vector.add(current.getHead().toString());
            }
            try {
                current = new SExpressions(current.getTail().getHead(), current.getTail().getTail());
            } catch (Exception e) {
                vector.add(current.getTail().eval(environment).toString());
                break;
            }
        }

        return combineString(vector);
    }
    
    private String combineString(final List<String> s) {
        if (s.size() == 0) return "";

        StringBuilder output = new StringBuilder();
        s.remove(s.size() - 1);
        for (int i = 0; i < s.size() - 1; i++) {
            output.append(s.get(i)).append(" ");
        }
        return output + s.get(s.size() - 1);
    }

    @Override
    public String toString() {
        if (isList()) {
            return toStringAsList();
        } else {
            return toStringAsSExpression();
        }
    }

    private String parens(final String s) {
        return "(" + s + ")";
    }

    private String dot() {
        return " . ";
    }
}
