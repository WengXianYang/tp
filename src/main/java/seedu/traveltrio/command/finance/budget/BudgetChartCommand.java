package seedu.traveltrio.command.finance.budget;

import seedu.traveltrio.TravelTrioException;
import seedu.traveltrio.model.budget.Budget;
import seedu.traveltrio.model.budget.BudgetList;
import seedu.traveltrio.model.activity.ActivityList;
import seedu.traveltrio.model.activity.Activity;

import java.util.Map;

public class BudgetChartCommand extends BudgetCommand {

    private static final int BAR_LENGTH = 20;

    public BudgetChartCommand(BudgetList budgetList, ActivityList activityList) {
        super(budgetList, activityList, null);
    }

    @Override
    public String execute() throws TravelTrioException {

        if (budgetList.isEmpty()) {
            return "No budgets found. Please set a budget first.";
        }

        StringBuilder result = new StringBuilder();
        result.append("Budget Usage Chart:\n\n");

        for (Map.Entry<Activity, Budget> entry : budgetList.getBudgets().entrySet()) {

            Activity activity = entry.getKey();
            Budget budget = entry.getValue();

            double total = budget.getActivityBudget();
            double spent = budget.getActualExpense();

            double percentage = (total == 0) ? 0 : (spent / total);
            int filledLength = (int) (percentage * BAR_LENGTH);

            String bar = "█".repeat(filledLength)
                    + "-".repeat(BAR_LENGTH - filledLength);

            result.append(String.format("%-15s | %s | %3.0f%%\n",
                    activity.getName(),
                    bar,
                    percentage * 100));
        }

        return result.toString();
    }
}
