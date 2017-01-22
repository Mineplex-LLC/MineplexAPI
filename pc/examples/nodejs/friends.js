let MineplexAPIWrapper = require('mineplex-api-wrapper'); //Calls the API

let api = new MineplexAPIWrapper(''); //Sets the API token

var player = 'SPMNJ' //The player we want to see its friends

api.getPlayerFriends(player, ('success','friends') => { //Asks the API for the lsit
	if (success == false) { //Checks to see if there are errors
		return console.log(success); //Returns the errors
	}
	else { //Runs the rest of the code
		var friendList = friends.name //Gets the array of friends
		console.log(`${player} has ${friendList.length} Friends and they are [${friendList.join()}]`);
	}
});
