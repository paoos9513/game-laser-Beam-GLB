package model;

public class Score {

    private Player root;

    public Score() {
        root = null;
    }

    public Player getRoot() {
        return root;
    }

    public void addPlayer(String name,int points){
        Player newPlayer = new Player(name, points);
        if (root==null){
            root = newPlayer;
        }else{
            addPlayer(root,newPlayer);

        }
    }
    private void addPlayer(Player currentPlayer,Player newPlayer){
        if (newPlayer.getPoints() < currentPlayer.getPoints() && currentPlayer.getLeft() == null){
            currentPlayer.setLeft(newPlayer);
        }else if (newPlayer.getPoints() > currentPlayer.getPoints() && currentPlayer.getRight() == null){
            currentPlayer.setRight(newPlayer);
        }else{
            if (newPlayer.getPoints()<currentPlayer.getPoints() & currentPlayer.getLeft()!=null){
                addPlayer(currentPlayer.getLeft(),newPlayer);

            }else{
                addPlayer(currentPlayer.getRight(),newPlayer);
            }
        }
    }

    public String printPlayer(Player root) throws NullPointerException{
        String gamer = " ";
        try {
            gamer += root.getPoints()+ " ";
            if (root.getLeft()!= null){
                gamer += printPlayer(root.getLeft());
            }else if(root.getLeft() == null){
                gamer += printPlayer(root.getRight());
            }else if(root.getRight() == null){
                gamer += printPlayer(root.getLeft());
            }

        } catch (Exception Ignored) {
        }
        return gamer;
    }

    public String toString(){
        String msg = " ";
        try {
            if (root == null){
                msg += "no players added";
            }else{
                msg = printPlayer(root);
            }

        } catch (Exception Ignored) {
        }

        return msg;
    }
}
