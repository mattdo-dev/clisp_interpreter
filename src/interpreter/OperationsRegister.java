package interpreter;

import operations.*;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.OperationRegisterer;

public class OperationsRegister implements OperationRegisterer {
    public static void registerLogic() {
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("and", new AndEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("or", new OrEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("not", new NotEvaluator());
    }

    public static void registerComparison() {
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("<", new LessEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew(">", new GreaterEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("<=", new LessOrEqualEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew(">=", new GreaterOrEqualEvaluator());
    }

    public static void basicOperations() {
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("quote", new QuoteEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("cond", new CondEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("list", new ListEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("eval", new EvalEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("load", new LoadEvaluator());
    }

    public static void a6Operations() {
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("setq", new SETQEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("lambda", new LambdaEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("function", new FunctionEvaluator());
        BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("funcall", new FunctionApplicationEvaluator());
    }

    public static void registerAll() {
        registerLogic();
        registerComparison();
        basicOperations();
        a6Operations();
    }

    @Override
    public void registerOperations() {
        registerAll();
    }
}
