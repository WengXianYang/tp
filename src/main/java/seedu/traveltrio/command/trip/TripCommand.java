package seedu.traveltrio.command.trip;

import seedu.traveltrio.TravelTrioException;
import seedu.traveltrio.model.trip.TripList;

/**
 * Abstract base class for all trip-related commands.
 * Provides access to the TripList for managing trips.
 */
public abstract class TripCommand {

    protected TripList tripList;

    /**
     * Constructs a TripCommand with the specified TripList.
     *
     * @param tripList the list of trips this command operates on
     */
    public TripCommand(TripList tripList) {
        this.tripList = tripList;
    }

    /**
     * Executes the command and returns the result message.
     *
     * @return the result message to display to the user
     * @throws TravelTrioException if an error occurs during command execution
     */
    public abstract String execute() throws TravelTrioException;

}

