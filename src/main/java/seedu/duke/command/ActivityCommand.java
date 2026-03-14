package seedu.duke.command;

import seedu.duke.model.Activity;
import seedu.duke.model.ActivityList;

import java.util.ArrayList;

public abstract class ActivityCommand {

    protected ActivityList activityList;

    public ActivityCommand(ActivityList activityList) {
        this.activityList = activityList;
    }

    public abstract String execute(String tripName);

}
