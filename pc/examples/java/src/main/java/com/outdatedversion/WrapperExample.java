package com.outdatedversion;

import com.outdatedversion.mineplex.MineplexAPI;
import com.outdatedversion.mineplex.Region;

import java.util.UUID;

/**
 * @author Ben (OutdatedVersion)
 * @since Dec/03/2016 (10:24 PM)
 */
public class WrapperExample
{

    private WrapperExample()
    {
        // Create a new builder then we'll do some configuration. Most
        // of the options provided in there you'll never use EXCEPT
        // 'withKey' - that one is pretty important.
        final MineplexAPI _api = MineplexAPI.builder().withKey("your-key").provide();

        // let's grab some data.. we'll use me as an example.
        _api.fetchProfile("OutdatedVersion", (profile, issue) ->
        {
            if (issue.isPresent())
            {
                // shoot, so something went wrong
                // with this request to the API.
                // Here you'd handle it however you
                // deal with errors within your app
                return;
            }

            // look over at my level
            System.out.println("Level: " + profile.level.value);

            // my current rank..
            System.out.println("Rank: " + profile.rank);

            // let's go through my friends..
            profile.friends.forEach(info -> System.out.println("A friend: " + info.name));

            // let's look at when it is that I was last on
            System.out.println("Last on: " + profile.lastLogin.toString());
        });

        // just a note: you may also use a UUID!
        _api.fetchProfile(UUID.fromString("03c337cd-7be0-4694-b9b0-e2fd03f57258"), (profile, issue) -> { ... });

        // maybe we wanna mess with some region data..
        // let's grab the current player count from us.mineplex.com
        _api.fetchRegionStatus(Region.US, (status, issue) ->
        {
            // if there's an issue, let's print
            // the stack trace then freeze
            if (issue.printTrace())
                return;

            System.out.println("Currently " + status.playerCount + " players are on the US network.");
        });

        // random data from the network
        _api.fetchNetworkStatus((status, issue) ->
        {
            // us.mineplex.com main MOTD
            System.out.println("US MOTD: " + status.us.motd.mainLine);

            // eu.mineplex.com player count..
            System.out.println("EU Player Count: " + status.eu.playerCount);
        });

        // Information on one server
        // in this case: the staff server on the US network
        _api.fetchServerStatus(Region.US, "Staff-1", (info, issue) ->
        {
            if (issue.isPresent())
                return;

            System.out.println("Staff-1 player count: " + info.playerCount);
        });

        // some details on the gem fountain
        _api.fetchFountainInfo((fountain, issue) ->
        {
            if (issue.isPresent())
                return;

            if (fountain.hasActiveBrawl)
                System.out.println("HEY GUYS. The brawl is active! (We made it to " + fountain.percentFilled + "%!)");
        });
    }

    /** entry point */
    public static void main(String[] args)
    {
        new WrapperExample();
    }

}
