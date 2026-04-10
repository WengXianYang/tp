package seedu.traveltrio.command.activity;

import seedu.traveltrio.TravelTrioException;
import seedu.traveltrio.model.activity.Activity;
import seedu.traveltrio.model.activity.ActivityList;

import java.time.LocalDateTime;

public class NextActivityCommand extends ActivityCommand {

    public NextActivityCommand(ActivityList activityList) {
        super(activityList);
    }

    @Override
    public String execute(String tripName) throws TravelTrioException {

        if (activityList.isEmpty()) {
            return "No activities found in this trip.";
        }

        LocalDateTime now = LocalDateTime.now();

        Activity nextActivity = null;
        LocalDateTime earliestTime = null;

        for (Activity activity : activityList.getAll()) {
            LocalDateTime activityTime = activity.getStartDateTime();

            if (activityTime == null) {
                continue;
            }

            if (activityTime.isAfter(now)) {
                if (earliestTime == null || activityTime.isBefore(earliestTime)) {
                    earliestTime = activityTime;
                    nextActivity = activity;
                }
            }
        }

        if (nextActivity == null) {
            return "No upcoming activities found.";
        }

        return "Next activity for " + tripName + ":\n\n"
                + nextActivity.formatForDisplay();
    }
}
