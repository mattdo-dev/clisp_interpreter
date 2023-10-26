package interpreter;

import atoms.InterpreterIdentifierAtom;
import gradingTools.comp524f21.assignment6.ClassRegistryA6;
import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.IdentifierAtom;
import operations.*;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.parser.terms.SExpression;

public class InterpreterClassRegistry implements ClassRegistryA6 {

    @Override
    public Class<?> getMain() {
        return InterpreterMain.class;
    }

    @Override
    public Class<? extends OperationRegisterer> getCustomOperationRegisterer() {
        return OperationsRegister.class;
    }

    @Override
    public Class<? extends SExpression> getStringFormattingSExpression() {
        return SExpressions.class;
    }

    @Override
    public Class<? extends Evaluator> getQuoteEvaluator() {
        return QuoteEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getEvalEvaluator() {
        return EvalEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getLoadEvaluator() {
        return LoadEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getCondEvaluator() {
        return CondEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getListEvaluator() {
        return ListEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getLTEvaluator() {
        return LessEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getGTEvaluator() {
        return GreaterEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getLTEEvaluator() {
        return LessOrEqualEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getGTEEvaluator() {
        return GreaterOrEqualEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getAndEvaluator() {
        return AndEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getOrEvaluator() {
        return OrEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getNotEvaluator() {
        return NotEvaluator.class;
    }

    @Override
    public Class<? extends SExpression> getFunctionCallingSExpression() {
        return null;
    }

    @Override
    public Class<? extends Evaluator> getLetEvaluator() {
        return null;
    }

    @Override
    public Class<? extends Evaluator> getFunctionEvaluator() {
        return FunctionEvaluator.class;
    }

    @Override
    public Class<? extends OperationRegisterer> getStatefulOperationRegisterer() {
        return null;
    }

    @Override
    public Class<? extends SExpression> getLambdaCallingSExpression() {
        return null;
    }

    @Override
    public Class<? extends IdentifierAtom> getIdentifierAtomWithLookup() {
        return InterpreterIdentifierAtom.class;
    }

    @Override
    public Class<? extends Environment> getNestedLexicalEnvironment() {
        return null;
    }

    @Override
    public Class<? extends Evaluator> getBasicFuncallEvaluator() {
        return FunctionApplicationEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getLambdaEvaluator() {
        return LambdaApplicationEvaluator.class;
    }

    @Override
    public Class<? extends Evaluator> getSetqEvaluator() {
        return SETQEvaluator.class;
    }
}
