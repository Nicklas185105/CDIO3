package main.Spil.Model;

/**
 * Create a new dialog asking for player input, then converts that into an player array and returns it
 * */
public class RetrievePlayerDialog {
    private GameState state;
    private LanguagePack stringContainer;

    public RetrievePlayerDialog(GameState state, LanguagePack stringContainer)
    {
        this.state = state;
        this.stringContainer = stringContainer;
    }

    public Player[] showPlayerDialog() {
        return getPlayers();
    }

    private Player[] getPlayers() {
        int n;

        while ((n = Integer.parseInt(state.getView().getUserSelection(stringContainer.getString("amount_players"), "2", "3", "4"))) <= 0) {
            state.getView().showMessage(stringContainer.getString("invalid_amount_players"));
        }

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {

            String name = state.getView().getUserString(stringContainer.getString("give_player_name", (i + 1)));
            String type = state.getView().getUserSelection(stringContainer.getString("select_card_type"), "Car", "Racecar", "Tractor", "UFO");

            Player player = new Player(name, 24 - 2 * n, type);
            players[i] = player;
            state.getView().addPlayer(player);
            state.getView().getFields()[0].setCar(player, true);
        }
        return players;
    }
}
