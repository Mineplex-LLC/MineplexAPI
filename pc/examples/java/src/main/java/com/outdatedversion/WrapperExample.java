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
        // well we'll need our base here first..
        // create a new builder then we'll do some configuration. most
        // of the options provided in there you'll never use EXCEPT
        // `withKey` - that one is pretty important. gonna yell at you
        // if you don't use that!
        final MineplexAPI _api = MineplexAPI.builder().withKey("your-key").provide();

        // let's grab some data.. we'll use me as an example.
        _api.fetchProfile("OutdatedVersion", (profile, issue) ->
        {
            if (issue.isPresent())
            {
                // shoot. somethin went wrong.
                // may wanna deal with it.
                return;
            }

            // maybe we can look at my level
            System.out.println("Level: " + profile.level.value);

            // my current rank..
            System.out.println("Rank: " + profile.rank);

            // let's go through my friends.. (ha I don't have any)
            profile.friends.forEach(info -> System.out.println("A friend: " + info.name));

            // ok maybe I wasn't online in that last example..
            // let's look at when it is that I was last on
            System.out.println("Last on: " + profile.lastLogin.toString());
        });

        // just a note: you may also use a UUID!
        _api.fetchProfile(UUID.fromString("03c337cd-7be0-4694-b9b0-e2fd03f57258"), (profile, issue) ->
        {
            // do stuff
        });

        // maybe we wanna mess with some region data..
        // let's grab the current player count from us.mineplex.com
        _api.fetchRegionStatus(Region.US, (status, issue) ->
        {
            if (issue.isPresent())
            {
                // uh oh a boo boo happened
                return;
            }

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

        // data from one server..
        // in this case the staff server on the US network
        _api.fetchServerStatus(Region.US, "Staff-1", (info, issue) ->
        {
            if (issue.isPresent())
            {
                // you know the drill..
                return;
            }

            System.out.println("Staff-1 player count: " + info.playerCount);
        });

        _api.fetchFountainInfo((fountain, issue) ->
        {
            if (issue.isPresent())
            {
                // ¯\_(ツ)_/¯
                return;
            }

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
