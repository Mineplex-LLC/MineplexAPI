import com.google.gson.Gson;

public class MineplexAPI
{

	public MineplexPlayer getPlayer(String json)
	{
		Gson gson = new Gson();
		MineplexPlayer player = gson.fromJson(json, MineplexPlayer.class);
		return player;
	}

}
