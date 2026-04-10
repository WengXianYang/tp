package seedu.traveltrio.command.finance.budget;

import org.junit.jupiter.api.Test;
import seedu.traveltrio.TravelTrioException;
import seedu.traveltrio.model.activity.Activity;
import seedu.traveltrio.model.activity.ActivityList;
import seedu.traveltrio.model.budget.Budget;
import seedu.traveltrio.model.budget.BudgetList;
import seedu.traveltrio.model.trip.Trip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BudgetChartCommandTest {

    @Test
    void execute_noBudgets_throwsException() {
        Trip trip = new Trip("Japan Trip", "2026-06-01", "2026-06-10");
        ActivityList activityList = new ActivityList(trip);
        BudgetList budgetList = new BudgetList();

        BudgetChartCommand command = new BudgetChartCommand(budgetList, activityList);

        assertThrows(TravelTrioException.class, command::execute);
    }

    @Test
    void execute_singleActivity_generatesCorrectChart() throws TravelTrioException {
        Trip trip = new Trip("Japan Trip", "2026-06-01", "2026-06-10");
        ActivityList activityList = new ActivityList(trip);
        BudgetList budgetList = new BudgetList();

        Activity activity = new Activity("Hiking", "Fuji",
                "2026-06-03", "09:00", "12:00");

        activityList.add(activity);

        Budget budget = new Budget(100, activity);
        budget.setActualExpense(50); // 50%

        budgetList.addBudget(activity, budget);

        BudgetChartCommand command = new BudgetChartCommand(budgetList, activityList);
        String result = command.execute();

        String expected = "Budget Usage Chart:\n" +
                "Hiking     [#####-----] 50%\n";

        assertEquals(expected, result);
    }

    @Test
    void execute_multipleActivities_generatesCorrectChart() throws TravelTrioException {
        Trip trip = new Trip("Japan Trip", "2026-06-01", "2026-06-10");
        ActivityList activityList = new ActivityList(trip);
        BudgetList budgetList = new BudgetList();

        Activity a1 = new Activity("Hiking", "Fuji",
                "2026-06-03", "09:00", "12:00");
        Activity a2 = new Activity("Diving", "Okinawa",
                "2026-06-04", "10:00", "14:00");

        activityList.add(a1);
        activityList.add(a2);

        Budget b1 = new Budget(100, a1);
        b1.setActualExpense(50); // 50%

        Budget b2 = new Budget(200, a2);
        b2.setActualExpense(100); // 50%

        budgetList.addBudget(a1, b1);
        budgetList.addBudget(a2, b2);

        BudgetChartCommand command = new BudgetChartCommand(budgetList, activityList);
        String result = command.execute();

        String expected = "Budget Usage Chart:\n" +
                "Hiking     [#####-----] 50%\n" +
                "Diving     [#####-----] 50%\n";

        assertEquals(expected, result);
    }

    @Test
    void execute_fullBudget_generatesFullBar() throws TravelTrioException {
        Trip trip = new Trip("Japan Trip", "2026-06-01", "2026-06-10");
        ActivityList activityList = new ActivityList(trip);
        BudgetList budgetList = new BudgetList();

        Activity activity = new Activity("Shopping", "Tokyo",
                "2026-06-05", "12:00", "18:00");

        activityList.add(activity);

        Budget budget = new Budget(100, activity);
        budget.setActualExpense(100); // 100%

        budgetList.addBudget(activity, budget);

        BudgetChartCommand command = new BudgetChartCommand(budgetList, activityList);
        String result = command.execute();

        String expected = "Budget Usage Chart:\n" +
                "Shopping   [##########] 100%\n";

        assertEquals(expected, result);
    }
}
