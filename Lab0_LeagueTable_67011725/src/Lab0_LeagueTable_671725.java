import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Lab0_LeagueTable_671725 {
    static int[][] computeTable(List<int[]> matches) { 
        int maxTeamId = 7; // number of teams
        int[][] stats = new int[maxTeamId][5];  // [teamId, MP, GF, GA, Pts]

        for (int i = 0; i < maxTeamId; i++)  
            stats[i][0] = i + 1; 

        for (int[] match : matches) {
            int teamA = match[0]; // {team_id, number_of_matches_played, goals_for, goals_against, points} 
            int teamB = match[1];
            int goalsA = match[2];
            int goalsB = match[3]; 

            int idxA = teamA - 1; // convert index to 0-based
            int idxB = teamB - 1;

            stats[idxA][1]++; // Increment matches played
            stats[idxB][1]++;

            stats[idxA][2] += goalsA; // update team A goals for
            stats[idxA][3] += goalsB; // update team A goals against

            stats[idxB][2] += goalsB; // update team B goals for
            stats[idxB][3] += goalsA; // update team B goals against

            if (goalsA > goalsB) {
                stats[idxA][4] += 3;
            } else if (goalsB > goalsA) {
                stats[idxB][4] += 3;
            } else {
                stats[idxA][4] += 1;
                stats[idxB][4] += 1;
            }
        }

        /*
            Integer.compare(x, y) returns:
            Returns a negative number if x < y
            Returns 0 if x == y
            Returns a positive number if x > y
         */

        // {teamId, matchesPlayed, goalsFor, goalsAgainst, points}
        Arrays.sort(stats, (a, b) -> {
            if (b[4] != a[4]) {
                return Integer.compare(b[4], a[4]);
            } // Compare by points
    
            // Calculate goal difference (GF - GA)
            int diffA = a[2] - a[3];
            int diffB = b[2] - b[3];
            if (diffB != diffA) {
                return Integer.compare(diffB, diffA);
            } // Compare by goal difference
            
            // Compare goals for (GF), descending order
            return Integer.compare(b[2], a[2]);
            });

        return stats;
    }


    static void displayTable(int [][] table, Map<Integer,String> teamNames) {
        System.out.println("Team  MP  GF  GA  Pts");
        for (int[] row : table) {
            String name = teamNames.getOrDefault(row[0], "Team" + row[0]);
            System.out.printf("%-5s %3d %3d %3d %4d\n",
                name, row[1], row[2], row[3], row[4]);
        }
    }

    static void demo_1(){
        Map<Integer, String> teamNames = Map.of( 
            1, "phy", 2, "chem", 3, "bio", 
            4, "math", 5, "stat", 6, "com", 7, "kdai" 
        ); // of method is used to creat map 

        // {teamA_id, teamB_id, teamA_goals, teamB_goals}
        List<int[]> results = Arrays.asList( 
                new int[]{1,2,1,2}, new int[]{1,3,2,0}, new int[]{1,4,0,0},  
                            new int[]{1,5,0,1}, new int[]{1,6,1,2}, new int[]{1,7,2,2},  
                                    new int[]{2,3,3,2}, new int[]{2,4,0,1},  
                            new int[]{2,5,3,3}, new int[]{2,6,3,0}, new int[]{2,7,2,0},  
                                                        new int[]{3,4,1,0},  
                            new int[]{3,5,1,0}, new int[]{3,6,2,3}, new int[]{3,7,0,0}, 
                                                                                    
                            new int[]{4,5,3,1}, new int[]{4,6,0,0}, new int[]{4,7,1,2}, 
                                                                                        
                                                new int[]{5,6,0,0}, new int[]{5,7,1,0}, 
                                                                    new int[]{6,7,1,0} 
                ); 
        int [][] table = computeTable(results); 
        
        displayTable(table, teamNames); 
    }

    public static void main(String[] args) throws Exception {
        demo_1();
    }
}
