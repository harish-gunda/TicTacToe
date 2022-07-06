import java.util.*;

public class MenaceStrategy {
    
    private int ALPHA;
    public Map<String, List<Integer>> beads = new HashMap<>();
    private Map<String, Integer> menaceMove = new HashMap<>();

    public MenaceStrategy(int ALPHA){
        this.ALPHA = ALPHA;
    }


    public void updateBeads(int result, int beta, int gamma, int delta) {
        if (result == 0) {
            for(Map.Entry<String, Integer> move:menaceMove.entrySet()){
                int j =0;
                while (j<delta) {
                    beads.get(move.getKey()).add(move.getValue());
                    j++;
                }
            }


        } else if (result == 1) {
            for(Map.Entry<String, Integer> move:menaceMove.entrySet()){
                int j =0;
                while (j<beta) {
                    beads.get(move.getKey()).add(move.getValue());
                    j++;
                }
            }
        } else {
            for(Map.Entry<String, Integer> move:menaceMove.entrySet()){
                int j =0;
                while (j<gamma) {
                    if(beads.get(move.getKey()).size()>1) {
                        beads.get(move.getKey()).remove(move.getValue());
                    }
                    j++;
                }
            }
        }
    }

    public int nextOptimalStep(String boardState) {
        Random rand = new Random();
        if (beads.containsKey(boardState)) {
            if (beads.get(boardState).size()<=1) {
                return beads.get(boardState).get(0);
            }
            int bead = beads.get(boardState).remove(rand.nextInt(beads.get(boardState).size()));
            menaceMove.put(boardState,bead);
            return bead;
        }
        else {
            createKeyValue(boardState);
            int bead = beads.get(boardState).remove(rand.nextInt(beads.get(boardState).size()));
            menaceMove.put(boardState,bead);
            return bead;
        }
    }

    public void createKeyValue(String boardState) {
        int zeros = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i=0; i<boardState.length(); i++) {
            if(boardState.charAt(i)=='0') {
                zeros++;
                for(int j = 0; j< ALPHA; j++){
                    positions.add(i);
                }
            }
        }
        if(zeros==0){
            for(int j = 0; j< ALPHA; j++){
                positions.add(-1);
            }
        }

        beads.put(boardState, positions);
    }




}
